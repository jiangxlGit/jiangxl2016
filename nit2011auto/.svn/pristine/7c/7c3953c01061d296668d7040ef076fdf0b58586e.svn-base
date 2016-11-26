package com.jiang.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.jiang.context.StaticValue;
import com.jiang.pojo.AccessToken;
/**
 * 
 * @功能概要： 根据url客服端发送GET或POST请求，服务端响应输出json对象的数据包<br>
 * @项目名称： 微信公众号开发<br>
 * @初创作者： jiangxl <836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-10-24 下午4:17:57<br>
 */
public class JsonUtil {

	/**
	 * 客户端发送Http GET请求，并返回json对象。<br><br>
	 * 在项目中的作用示例：<br>
	 * 获取access_token（公众号的全局唯一接口调用凭据）<br>
	 * 1. 正常情况下，微信会返回下述JSON数据包给公众号，数据如下：
	 * <p><blockquote><pre>
	 * {"access_token":"ACCESS_TOKEN","expires_in":7200}
	 * </pre></blockquote><p>
	 * 2. 错误时,微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:
	 * <p><blockquote><pre>
	 * {"errcode":40013,"errmsg":"invalid appid"}
	 * </pre></blockquote><p>
	 * @param url
	 * @return JSONObject
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doGetJsonObject(String url)
			throws ClientProtocolException, IOException {
		// 客户端发送Http get请求
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity httpEntity = response.getEntity();
		if (httpEntity != null) {
			String result = EntityUtils.toString(httpEntity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}

	/**
	 * 客户端发送Http POST请求，并返回json对象。<br><br>
	 * 在项目中的作用示例：<br>
	 * 创建菜单<br>
	 * 1. 正确时的返回JSON数据包如下：<br><br>
	 * <p><blockquote><pre>
	 * {"errcode":0,"errmsg":"ok"}
	 * </pre></blockquote><p>
	 * 2. 错误时的返回JSON数据包如下（示例为无效菜单名长度）:
	 * <p><blockquote><pre>
	 * {"errcode":40018,"errmsg":"invalid button name size"}
	 * </pre></blockquote><p>
	 * @param url
	 * @return JSONObject
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static JSONObject doPostJsonObject(String url, String outStr) 
			throws ClientProtocolException, IOException{
		// 客户端发送Http post请求
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
		HttpResponse response = httpClient.execute(httpPost);
		if(response != null){
			String result = EntityUtils.toString(response.getEntity(),"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		
		return jsonObject;
	}
	/**
	 * 
	 * 方法说明： 返回accessToken <br>
	 * 创建时间：2016-10-24 下午5:05:15 <br>
	 * @return AccessToken
	 *
	 */
	public static AccessToken getAccessToken(){
		AccessToken accessToken = new AccessToken();
		String url = StaticValue.ACCESS_TOKEN_URL.replace("APPID", StaticValue.APPID).
										replace("APPSECRET", StaticValue.APPSECRET);
		JSONObject jsonObject = null;
		// 客户端发送Http get请求
		try {
			jsonObject = doGetJsonObject(url);
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


















