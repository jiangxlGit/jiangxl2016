package com.jiang.test;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import com.jiang.context.StaticValue;
import com.jiang.util.JsonUtil;

public class GetAccessTokenTest {

	public static void main(String[] args) {
		
		String url = StaticValue.ACCESS_TOKEN_URL.replace("APPID", StaticValue.APPID).
										replace("APPSECRET", StaticValue.APPSECRET);
		JSONObject jsonObject = null;
		// 客户端发送Http get请求
		try {
			jsonObject = JsonUtil.doGetJsonObject(url);
			if (jsonObject != null) {
				System.out.println(jsonObject.getString("access_token"));
				System.out.println(jsonObject.getString("expires_in"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
