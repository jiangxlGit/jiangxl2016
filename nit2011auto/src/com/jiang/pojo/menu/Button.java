package com.jiang.pojo.menu;

/**
 * 
 * @功能概要： 菜单的按钮pojo类
 * @项目名称： 微信公众号开发
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-23 上午11:22:05
 */
public class Button {

	private String name;			// 菜单标题，不超过16个字节，子菜单不超过60个字节
	private String type;			// 菜单的响应动作类型
	private Button[] sub_button;	// 二级菜单数组，个数应为1~5个
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
}
