package com.jiang.util;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;

import com.jiang.context.StaticValue;
import com.jiang.pojo.menu.Button;
import com.jiang.pojo.menu.ClickButton;
import com.jiang.pojo.menu.Menu;
import com.jiang.pojo.menu.ViewButton;

public class MenuUtil {

	/**
	 * 用于菜单的初始化
	 * @return
	 */
	public static Menu initMenu(){
		
		// 先创建一个菜单，用于存放button数组
		Menu menu = new Menu();
		
		ClickButton button1 = new ClickButton();
		button1.setKey("1");
		button1.setName("录入信息");
		button1.setType("click");
		
		ViewButton button2 = new ViewButton();
		button2.setName("毕业照");
		button2.setType("view");
		button2.setUrl(StaticValue.MENU_ClICK_URL);
		
		ClickButton button3_1 = new ClickButton();
		button3_1.setKey("31");
		button3_1.setName("班级趣事");
		button3_1.setType("click");
		
		ClickButton button3_2 = new ClickButton();
		button3_2.setKey("32");
		button3_2.setName("扫描支付");
		button3_2.setType("click");
		
		ClickButton button3_3 = new ClickButton();
		button3_3.setKey("33");
		button3_3.setName("地理位置");
		button3_3.setType("click");
		
		Button button3 = new Button();
		button3.setName("其他功能");
		button3.setSub_button(new Button[]{button3_1,button3_2,button3_3});
		
		menu.setButton(new Button[]{button1,button2,button3});
		
		return menu;
	}
	
	public static int createMenu(String accessToken, String menu) 
			throws ClientProtocolException, IOException{
		int result = 0;
		String url = StaticValue.MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = JsonUtil.doPostJsonObject(url, menu);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		return result;
	}
	
}
