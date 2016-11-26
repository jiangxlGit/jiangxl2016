package com.jiang.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import com.jiang.pojo.AccessTokenDB;
import com.jiang.util.HibernateSessionFactory;

/**
 * 
 * @功能概要： 定时更新AccessToken的DAO层实现<br>
 * @项目名称： 微信公众号开发<br>
 * @初创作者： jiangxl <836200494@qq.com><br>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.<br>
 * @创建时间： 2016-11-6 下午10:08:39<br>
 */
public class AccessTokenDao implements IAccessTokenDao<AccessTokenDB>{

	@SuppressWarnings("unchecked")
	public List<AccessTokenDB> getAccessTokenDB() {
		/**
		 * 如果配置了current_session_context_class=thread的话，
		 * 使用getCurrentSession会先去获取与线程对应的session，
		 * 如果没有获取到的话，则会创建一个，在事务提交的时候，
		 * 该session会自动关闭,不需要手动关闭session。
		 * 另外：openSession()重新建立一个新的session
		 */
		Session session = HibernateSessionFactory.getSessionFactory().getCurrentSession();
		session.setFlushMode(FlushMode.COMMIT);//提交时和flush()时清理缓存
		String sql = " SELECT  * FROM tb_access_token a WHERE a.create_date = (SELECT MAX(b.create_date) FROM tb_access_token b ) ";
		try {
			session.beginTransaction();
			return session.createSQLQuery(sql).addEntity("tb_access_token", AccessTokenDB.class).list();
		} finally {
			session.getTransaction().commit();
		}
	}

	@SuppressWarnings("unused")
	public Integer updateAccessTokenDB(AccessTokenDB accessTokenDB) {
		
		String access_token = accessTokenDB.getAccessToken();	 	 // 获取到的凭证
		Integer expires_in = accessTokenDB.getExpiresIn(); 		 	 // 凭证有效时间，单位：秒
		Integer expires_custom = accessTokenDB.getExpiresCustom();	 // 获取access_token的提前时间
		Date create_date = accessTokenDB.getCreateDate();		 	// 创建时间
		
		String sql = "";
		
		Session session = HibernateSessionFactory.getSession();
		session.setFlushMode(FlushMode.COMMIT);//提交时和flush()时清理缓存
		
		sql = " UPDATE tb_access_token a " +
			  " SET access_token = '"+access_token+"', expires_in = "+expires_in+", expires_custom = "+expires_custom+", create_date = NOW() "+
			  " WHERE a.id = 1 " ;
		
		try {
			session.beginTransaction();
			return session.createSQLQuery(sql).addEntity("tb_access_token", AccessTokenDB.class).executeUpdate();
		} finally {
			session.getTransaction().commit();
			if(session!=null){
				session.close();
			}
		}
	}

}
