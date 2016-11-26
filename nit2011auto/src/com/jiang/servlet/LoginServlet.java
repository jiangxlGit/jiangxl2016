package com.jiang.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jiang.bean.PersonInfo;
import com.jiang.biz.WeixinBiz;
import com.jiang.pojo.Student;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -4460122973578974212L;

	private static WeixinBiz weixinBiz = new WeixinBiz();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String method = "loginToInputData";
		
		try {
			method = method = request.getParameter("method");
			if(method == null){
				 method = "loginToInputData";
			} 
			Class c = this.getClass();
			Class[] parameterTypes = { HttpServletRequest.class,
					HttpServletResponse.class };
			Method clazzMethod = c.getMethod(method, parameterTypes);
			Object[] Objparams = { request, response };
			clazzMethod.invoke(this, Objparams);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void loginToInputData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String getStudentId = "";
		List<Student> list = null;
		HttpSession session = request.getSession();
		String result = "true";
		InetAddress inetAddress = InetAddress.getLocalHost();
		PersonInfo personInfo = new PersonInfo();
		try {
			
			list = weixinBiz.findByName(username);
			if(list != null && list.size()>0){
				getStudentId = list.get(0).getStudentId();
			} else {
				result = "false";
			}
			
			if ("".equals(password) || !getStudentId.equals(password)) {
				result = "false";
			}
			if("true".equals(result)){
				personInfo.setAccount(username);
				personInfo.setIp(inetAddress.getHostAddress());
				personInfo.setLoginDate(new Date());
			}
		} catch (Exception e) {
			result = "false";
			e.printStackTrace();
		} finally {
			session.setAttribute("login", result);
			session.setAttribute("personInfo", personInfo);
			response.getWriter().print(result);
		}
		
	}

}
