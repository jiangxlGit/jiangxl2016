package com.jiang.biz;

import java.io.IOException;
import java.util.List;

import org.dom4j.DocumentException;

/**
 * 
 * @功能概要： 微信公众号BIZ层接口<br>
 * @项目名称： 微信公众号开发<br>
 * @初创作者： jiangxl <836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-11-6 下午10:10:52<br>
 */
public interface IWeixinBiz<T> {

	public List<T> findById(String id);
	
	public List<T> findByPrimaryId(String id);
	
	public List<T> findByName(String name);
	
	public Integer update(String id, String updateStr, int updateType);
	
	public String replyMessage(String xmlString) throws IOException, DocumentException;
}
