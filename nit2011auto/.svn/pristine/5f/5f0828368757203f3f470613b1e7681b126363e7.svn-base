package com.jiang.thread;

import java.util.Date;
import java.util.List;

import com.jiang.context.StaticValue;
import com.jiang.dao.AccessTokenDao;
import com.jiang.pojo.AccessToken;
import com.jiang.pojo.AccessTokenDB;
import com.jiang.util.AccessTokenUitl;

public class AccessTokenThread implements Runnable{
	
	@SuppressWarnings("unused")
	private String myThreadName;
	
	public AccessTokenThread(String myThreadName){
		this.myThreadName = myThreadName;
	}
	
	public void run() {
		
		try {
			while(true){
				updateAccessToken();
				System.out.println("休眠"+(StaticValue.EXPIRES_IN - StaticValue.GET_ACCESS_TOKEN_ADVANCE_S));
				Thread.sleep( (StaticValue.EXPIRES_IN - 
						StaticValue.GET_ACCESS_TOKEN_ADVANCE_S)*1000L );
			}
		} catch (Exception e) {
			System.out.println("更新access_token异常");
			e.printStackTrace();
		}
		
	}
	
	public static synchronized void updateAccessToken() 
			throws NumberFormatException, InterruptedException{
		System.out.println(Thread.currentThread());
		AccessToken accessToken = null;
		Date date = null;
		//从数据库获取access_token相关数据
		AccessTokenDao dao = new AccessTokenDao();
		List<AccessTokenDB> list =  dao.getAccessTokenDB();
		AccessTokenDB accessTokenDB = list.get(0);
		System.out.println("获取数据库中的时间（上一次获取服务器的时间）："+accessTokenDB.getCreateDate().getTime()/1000);
		
		/**
		 * 若accessTokenDB不为空，则计算是否超时，
		 * 若超时，则从服务器获取access_token，
		 * 若accessTokenDB为空，也从服务器获取access_token。
		 */
		if (accessTokenDB!=null && accessTokenDB.getAccessToken().length()>0) {
			
			long time = (new Date().getTime() - accessTokenDB.getCreateDate().getTime())/1000;
			
			if ( time >= (StaticValue.EXPIRES_IN - StaticValue.GET_ACCESS_TOKEN_ADVANCE_S) ) {
				System.out.println("获取服务器的时间："+new Date().getTime()/1000 );
				accessToken = AccessTokenUitl.getServerAccessToken();
				date = new Date();
			} 
			
		} else {
			accessToken = AccessTokenUitl.getServerAccessToken();
			date = new Date();
		}
		
		//若accessToken不为空，则代表刚从服务器获取了access_token，则更新到数据库
		if(accessToken != null && accessToken.getAccess_token().length()>0){
			accessTokenDB.setAccessToken(accessToken.getAccess_token());
			accessTokenDB.setExpiresIn( Integer.valueOf(accessToken.getExpires_in()) );
			accessTokenDB.setExpiresCustom(StaticValue.GET_ACCESS_TOKEN_ADVANCE_S);
			accessTokenDB.setCreateDate(date);
			dao.updateAccessTokenDB(accessTokenDB);
		}
	}

}
