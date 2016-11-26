package com.jiang.listener
;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.jiang.bean.PersonInfo;

public class SessionListener implements HttpSessionAttributeListener {

	Map<String, HttpSession> map = new HashMap<String, HttpSession>();

	public void attributeAdded(HttpSessionBindingEvent event) {
		
		String name = event.getName();
		System.out.println("SessionListener的添加属性监听方法，添加了："+name);

		// 登录
		if (name.equals("personInfo")) {

			PersonInfo personInfo = (PersonInfo) event.getValue();

			if (map.get(personInfo.getAccount()) != null) {

				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(personInfo.getAccount());
				PersonInfo oldPersonInfo = (PersonInfo) session
						.getAttribute("personInfo");

				System.out.println("帐号" + oldPersonInfo.getAccount() + "在"
						+ oldPersonInfo.getIp() + "已经登录，该登录将被迫下线。");

				session.removeAttribute("personInfo");
				session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}

			// 将session以用户名为索引，放入map中
			map.put(personInfo.getAccount(), event.getSession());
			System.out.println("帐号" + personInfo.getAccount() + "在" + personInfo.getIp()
					+ "登录。");
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {

		
		String name = event.getName();
		System.out.println("SessionListener的删除属性监听方法，添加了："+name);

		// 注销
		if (name.equals("personInfo")) {
			// 将该session从map中移除
			PersonInfo personInfo = (PersonInfo) event.getValue();
			map.remove(personInfo.getAccount());
			System.out.println("帐号" + personInfo.getAccount() + "注销。");
		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {

		
		String name = event.getName();
		System.out.println("SessionListener的更换属性监听方法，添加了："+name);

		// 没有注销的情况下，用另一个帐号登录
		if (name.equals("personInfo")) {

			// 旧的的登录信息
			PersonInfo oldPersonInfo = (PersonInfo) event.getSession()
					.getAttribute("personInfo");
			// 新的登录信息
			PersonInfo personInfo = (PersonInfo) event.getValue();
			if(oldPersonInfo.getAccount().equals(personInfo.getAccount())){
				if (!oldPersonInfo.getIp().equals(personInfo.getIp())) {
					map.remove(oldPersonInfo.getAccount());
					System.out.println("您的帐号"+personInfo.getAccount()+"已经在其他机器上登录，您被迫下线。");
				} else {
					System.out.println("帐号"+personInfo.getAccount()+"重复登录");
				}
			}

			// 也要检查新登录的帐号是否在别的机器上登录过
			if (map.get(personInfo.getAccount()) != null) {
				// map 中有记录，表明该帐号在其他机器上登录过，将以前的登录失效
				HttpSession session = map.get(personInfo.getAccount());
				session.removeAttribute("personInfo");
				session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
			}
			map.put("personInfo", event.getSession());
		}

	}

}
