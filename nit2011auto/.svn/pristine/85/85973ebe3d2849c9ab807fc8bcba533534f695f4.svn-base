package com.jiang.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import com.jiang.context.StaticValue;
import com.jiang.pojo.AccessToken;

public class AccessTokenUitl {

	/**
	 * 
	 * 方法说明： 从服务器获取access_token <br>
	 * 创建时间：2016-10-24 下午5:05:15 <br>
	 * @return AccessToken
	 *
	 */
	public static AccessToken getServerAccessToken(){
		AccessToken accessToken = new AccessToken();
		String url = StaticValue.ACCESS_TOKEN_URL.replace("APPID", StaticValue.APPID).
										replace("APPSECRET", StaticValue.APPSECRET);
		JSONObject jsonObject = null;
		// 客户端发送Http get请求
		try {
			jsonObject = JsonUtil.doGetJsonObject(url);
			if (jsonObject != null) {
				accessToken.setAccess_token(jsonObject.getString("access_token"));
				accessToken.setExpires_in(jsonObject.getString("expires_in"));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return accessToken;
	}
	
}




















