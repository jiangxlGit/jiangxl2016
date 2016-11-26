package com.jiang.pojo.message;

/**
 * 
 * @功能概要： 文本输入消息pojo类
 * @项目名称： 微信公众号开发
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-22 下午2:45:17
 */

public class TextInputMassage {

	private String ToUserName;		//	开发者微信号
	private String FromUserName;	//	发送方帐号（一个OpenID）
	private Long   CreateTime;		//	消息创建时间 （整型）
	private String MsgType;			//	text
	private String Content;			//	文本消息内容
	private Long   MsgId;			//	消息id，64位整型
	
	public String getToUserName() {
		return ToUserName;
	}
	
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	
	public String getFromUserName() {
		return FromUserName;
	}
	
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	
	public Long getCreateTime() {
		return CreateTime;
	}
	
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	
	public String getMsgType() {
		return MsgType;
	}
	
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	public String getContent() {
		return Content;
	}
	
	public void setContent(String content) {
		Content = content;
	}
	
	public Long getMsgId() {
		return MsgId;
	}
	
	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
	
}
