package com.jiang.dao;

import java.util.List;

/**
 * 
 * @功能概要： 微信公众号DAO接口<br>
 * @项目名称： MDOS<br>
 * @初创作者： jiangxl <link 836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-10-26 上午10:07:34<br>
 */
public interface IWeixinDao<T> {

	/**
	 * 把对象写数据库
	 * @param object
	 */
	public void create(T object);
	
	/**
	 * 
	 * 更新数据<br>
	 * @param object
	 * @return 
	 *
	 */
	public Integer update(String id, String updateStr, int updateType);
	
	/**
	 * 根据主键id返回List
	 * @param catClass
	 * @param id
	 * @return
	 */
	public List<T> findByPrimaryId(String id);
	
	/**
	 * 
	 * 根据名字返回List<br>
	 * @param name
	 * @return 
	 *
	 */
	public List<T> findByName(String name);
	
	/**
	 * 根据studentId返回List 
	 * @param studentId
	 * @return
	 */
	public List<T> findByStudentId(String id);
	
	
}
