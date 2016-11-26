package com.jiang.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jiang.context.StaticValue;

/**
 * 
 * @功能概要： 通过检验signature对请求进行校验
 * @项目名称： 微信公众号开发
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-22 上午10:24:56
 */
public class CheckUtil {

	public static boolean checkSignature(String signature, String timestamp,
			String nonce) {
		/**
		 * 2.2 开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，
		 * 请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。加密/校验流程如下：
		 * 1）将token、timestamp、nonce三个参数进行字典序排序 
		 * 2）将三个参数字符串拼接成一个字符串进行sha1加密
		 * 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		 */
		List<String> list = new ArrayList<String>();
		list.add(StaticValue.TOKEN);
		list.add(timestamp);
		list.add(nonce);

		// 字典排序
		if (timestamp != null && nonce != null) {
			Collections.sort(list);
		}

		// 拼接成字符串
		StringBuffer content = new StringBuffer();
		for (String str : list) {
			content.append(str);
		}

		// 把拼接好的字符串进行sha1加密
		String temp = CreateSha1Util.getSha1(String.valueOf(content));
		// 检验结果
		boolean checkResult = false;
		// 加密后的字符串可与signature对比
		checkResult = temp.equals(signature);

		return checkResult;
	}

}
