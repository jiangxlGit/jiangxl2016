package com.jiang.util;

import java.security.MessageDigest;
/**
 * 
 * @功能概要： 对字符串进行sha1加密，加密后返回结果
 * @项目名称： 微信公众号开发
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-22 上午10:21:00
 */
public class CreateSha1Util {

	 public static String getSha1(String str){
	        if(str==null||str.length()==0){
	            return null;
	        }
	        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9',
	                'a','b','c','d','e','f'};
	        try {
	            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	            mdTemp.update(str.getBytes("UTF-8"));

	            byte[] md = mdTemp.digest();
	            int j = md.length;
	            char buf[] = new char[j*2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                buf[k++] = hexDigits[byte0 & 0xf];      
	            }
	            return new String(buf);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("sha1生成异常！");
	            return null;
	        }
	    }
	
}
