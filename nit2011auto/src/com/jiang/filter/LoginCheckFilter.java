package com.jiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {  
	
	protected FilterConfig filterconfig = null;
	
	private String loginKey = null;
	
    public void destroy() {  
    	System.out.println("这是LoginCheckFilter的销毁方法！");
    	loginKey = null;
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
        FilterChain chain) throws IOException, ServletException {  
    	System.out.println("这是LoginCheckFilter的业务处理方法！");
        HttpServletRequest req = (HttpServletRequest)request;  
        HttpServletResponse res = (HttpServletResponse)response;  
          
        //如果没有登录.  
        String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/",1),req.getRequestURI().length());  
      
        //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面就不去检查.  
        if(!"/login/index.jsp".equals(requestURI)) {  
            //取得session. 如果没有session则自动会创建一个, 我们用false表示没有取得到session则设置为session为空.  
            HttpSession session = req.getSession(false);
           
            String str = null;
            
            //如果没有登录过或登录失败.  
            if(session != null){
            	str = String.valueOf( session.getAttribute(loginKey));
            }
            if(session == null || str == null || str == "false") {  
                res.sendRedirect(req.getContextPath() + "/login/index.jsp");  
                //返回  
                return;  
            }  
              
        }  
        //session中的内容等于登录页面, 则可以继续访问其他区资源.  
        chain.doFilter(req, res);  
    }

	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("这是LoginCheckFilter的初始化方法！");
		this.filterconfig = filterconfig;
		loginKey = filterconfig.getInitParameter("loginKey");
	}  
}  
