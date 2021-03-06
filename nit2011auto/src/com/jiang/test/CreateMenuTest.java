package com.jiang.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import net.sf.json.JSONObject;

import com.jiang.pojo.AccessToken;
import com.jiang.util.JsonUtil;
import com.jiang.util.MenuUtil;

public class CreateMenuTest {

	public static void main(String[] args) {
		try {
			AccessToken accessToken = JsonUtil.getAccessToken();
			System.out.println("access_token:"+accessToken.getAccess_token());
			System.out.println("expires_in:"+accessToken.getExpires_in());
			String menu = JSONObject.fromObject(MenuUtil.initMenu()).toString();
			int result = MenuUtil.createMenu(accessToken.getAccess_token(), menu);
			if(result == 0){
				System.out.println("创建菜单成功！");
			} else {
				System.out.println("创建菜单失败！错误码为："+result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
