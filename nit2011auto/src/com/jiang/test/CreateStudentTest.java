package com.jiang.test;

import java.util.Date;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jiang.pojo.Student;
import com.jiang.util.HibernateSessionFactory;
/**
 * 
 * @功能概要： 测试用
 * @项目名称： MDOS
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-14 上午9:21:12
 */
public class CreateStudentTest {
	
	public static void main(String[] args) {
		
		Student student = new Student();
		
		student.setName("江新林");
		student.setStudentId("2011100895");
		student.setHomeAddress("江西九江");
		student.setWorkAddress("深圳南山");
		student.setWorkUnit("深圳梦网科技");
		student.setPost("java开发工程师");
		student.setGender("男");
		student.setTelephone("17704020131");
		student.setCreateDate(new Date());
		
		Session session = null;
		Transaction trans = null;
		
		try {
			
			//开启一个hibernate对话
			session = HibernateSessionFactory.getSession();
			session.setFlushMode(FlushMode.COMMIT);//提交时和flush()时清理缓存
			//开启一个hibernate事务
			trans = session.beginTransaction();
			
			//写入数据库
			session.persist(student);
			
			trans.commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			trans.rollback();
			
		} finally {
			if(session != null){
				session.close();
			}
		}
		
	}
	
}



















