package com.jiang.test;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import com.jiang.context.StaticValue;
import com.jiang.pojo.AccessToken;
import com.jiang.util.JsonUtil;

public class GetWeixinIPTest {

	public static void main(String[] args) {
		AccessToken accessToken = JsonUtil.getAccessToken();
		String url = StaticValue.GET_WEIXIN_IP_URL.replace("ACCESS_TOKEN", accessToken.getAccess_token());
		try {
			JSONObject jsonObject = JsonUtil.doGetJsonObject(url);
			boolean bool = jsonObject.containsKey("ip_list");
			System.out.println(bool);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
