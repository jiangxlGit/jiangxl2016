package com.jiang.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.jiang.biz.WeixinBiz;
import com.jiang.thread.AccessTokenThread;
import com.jiang.util.CheckUtil;
import com.jiang.util.MessageUtil;

/**
 * 
 * @功能概要： 微信业务逻辑实现<br>
 * @项目名称： 微信公众号开发<br>
 * @初创作者： jiangxl <836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-10-22 下午12:22:39<br>
 */
public class WeixinServlet extends HttpServlet {

	private static final long serialVersionUID = 5244765122759725352L;
	
	private static WeixinBiz weixinBiz = new WeixinBiz();
	
	private static ExecutorService fixedThreadPool  = Executors.newFixedThreadPool(1);
	private static AccessTokenThread t  = 
			new AccessTokenThread("定时更新AccessToken的线程");
	private static Logger logger = Logger.getLogger("微信Servlet:"+WeixinServlet.class);
	
	static {
		Thread thread = new Thread(t);
		fixedThreadPool.execute(thread);
		System.out.println("线程:"+thread.getId());
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {  
        System.out.println("Log4JInitServlet 正在初始化 log4j日志设置信息");  
        String log4jLocation = config.getInitParameter("log4j-properties-location");  
        ServletContext sc = config.getServletContext();  
        
        //log4jLocation为空则使用log4j默认的配置
        if (log4jLocation == null) {  
            System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");  
            BasicConfigurator.configure();  
        } else {  
            String webAppPath = sc.getRealPath("/");  
            String log4jProp = webAppPath + log4jLocation;  
            File yoMamaYesThisSaysYoMama = new File(log4jProp);  
            if (yoMamaYesThisSaysYoMama.exists()) {  
                System.out.println("使用: " + log4jProp+"初始化日志设置信息");  
                PropertyConfigurator.configure(log4jProp);  
            } else {  
                System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");  
                BasicConfigurator.configure();  
            }  
        }  
        super.init(config);  
    }
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		/**
		 * 第一步：填写服务器配置（在官网填写再提交） 
		 * 第二步：验证消息的确来自微信服务器
		 * 开发者提交信息后，微信服务器将发送GET请求
		 * 到填写的服务器地址URL上，GET请求携带参数如下表所示：
		 */
		String signature = request.getParameter("signature");	// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");	// 时间戳
		String nonce = request.getParameter("nonce"); 			// 随机数
		String echostr = request.getParameter("echostr"); 		// 随机字符串

		PrintWriter out = response.getWriter();
		
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		} else {
			out.print("");
		}
		out.flush();
		out.close();

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 输出流
		PrintWriter out = null;
		// 返回的xml字符串
		String returnXml = "";
		
		try {
			
			out = response.getWriter();
			//先回复一个空字符串，防止超过5秒出现“该公众号暂时无法提供服务，请稍后再试”的消息！
			out.print("");
			out.flush();
			
			//加密类型
			String encryptType = request.getParameter("encrypt_type");
			// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
			String signature = request.getParameter("signature");
			// 时间戳
			String timestamp = request.getParameter("timestamp");
			// 随机数
			String nonce = request.getParameter("nonce"); 				
			
			//对url进行校验
			if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
				
				//若encryptType为aes，则需解密
				if( encryptType == null || "raw".equals(encryptType) ){
					logger.info("校验通过，接收到消息未加密！");
					String xmlString = MessageUtil.requestToXml(request);
					returnXml = weixinBiz.replyMessage(xmlString);
					
				} else if("aes".equals(encryptType)){
					logger.info("校验通过，接收到消息已加密！加密类型为："+encryptType);
					//解密发来的被加密的消息，转化成xml格式的明文
					String decryptXml = MessageUtil.decryptMsgToXml(request);
					//对加密后的消息进行业务处理，返回需要回复的xml格式的消息
					String repMsg = weixinBiz.replyMessage(decryptXml);
					//加密回复的消息
					returnXml = MessageUtil.getWXBizMsgCrypt().encryptMsg(repMsg, "", nonce);
				}
				
			}
			
		} catch (Exception e) {
			logger.error(e.fillInStackTrace());
			System.out.println("处理消息异常！");
			e.printStackTrace();
		} 
		
		out.print(returnXml);
		out.flush();
		out.close();
	}

	@Override
	public void destroy(){
		try {
			fixedThreadPool.shutdown();
			while (!fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS)) {  
			    System.out.println("线程池没有关闭"); 
			}
			System.out.println("线程池已经关闭");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	
}
