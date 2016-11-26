package com.jiang.pojo.message;
/**
 * 
 * @功能概要： 文本输出消息pojo类
 * @项目名称： 微信公众号开发
 * @初创作者： jiangxl <836200494@qq.com>
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 * @创建时间： 2016-10-22 下午7:03:23
 */
public class TextOutputMassage {

	private String ToUserName;		 //	接收方帐号（收到的OpenID）
	private String FromUserName;	 //	开发者微信号
	private Long   CreateTime;		 //	消息创建时间 （整型）
	private String MsgType;			 //	text
	private String Content;			 //	回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	private String funcFlag; 		 // 这里的funcFlag，微信平台接口文档里没有，可以不写
	
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

	
	public String getFuncFlag() {
		return funcFlag;
	}
	

	public void setFuncFlag(String funcFlag) {
		this.funcFlag = funcFlag;
	}
	
}
