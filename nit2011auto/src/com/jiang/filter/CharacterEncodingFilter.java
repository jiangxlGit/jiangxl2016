package com.jiang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	private static String characterEncodingType = null;
	
	public void destroy() {
		
		System.out.println("这是CharacterEncodingFilter的销毁方法！");
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("这是CharacterEncodingFilter的业务处理方法！");
		if( characterEncodingType==null || "".equals(characterEncodingType) ){
			request.setCharacterEncoding("UTF-8");
		} else {
			request.setCharacterEncoding(characterEncodingType);
		}
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
		System.out.println("这是CharacterEncodingFilter的初始化方法！");
		characterEncodingType = filterConfig.getInitParameter("encoding");
		System.out.println("从web.xml的init-param中获取的参数："+characterEncodingType);
		
	}

}
