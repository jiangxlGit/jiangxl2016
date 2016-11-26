package com.jiang.context;

public class StaticValue {

	/**
	 * Token的值会保存到微信后台,只有微信后台和公众账号服务器知道这个字符串
	 */
	public static final String TOKEN = "jiang";
	
	/**
	 * 消息加解密密钥
	 */
	public static final String EncodingAESKey = "P8rJt9yROYlCWy5XEHPAUea5sV88YDupHBX75gIC3tL";
	
	/**
	 * 获取access_token相关参数：凭证有效时间（单位：S）
	 */
	public static final Integer EXPIRES_IN = 7200;
	
	/**
	 * 获取access_token相关参数：设置获取access_token的提前时间（单位：S）
	 */
	public static final Integer GET_ACCESS_TOKEN_ADVANCE_S = 60;
	
	/**
	 * 正则表达式：用于验证输入的学号
	 */
	public static final String REGEX_STUDENT_ID = "^2011[0-9]{6}\\+\\S{2,9}$";
	
	/**
	 * 正则表达式：用于验证输入的手机号码
	 */
	public static final String REGEX_TELEPHONE = "^(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}$";
	
	/** 
     * 返回消息类型：文本 
     */  
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";  

    /** 
     * 返回消息类型：音乐 
     */  
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";  

    /** 
     * 返回消息类型：图文 
     */  
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";  

    /** 
     * 请求消息类型：文本 
     */  
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";  

    /** 
     * 请求消息类型：图片 
     */  
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";  

    /** 
     * 请求消息类型：链接 
     */  
    public static final String REQ_MESSAGE_TYPE_LINK = "link";  

    /** 
     * 请求消息类型：地理位置 
     */  
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";  

    /** 
     * 请求消息类型：音频 
     */  
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";  

    /** 
     * 请求消息类型：视频
     */  
    public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
    
    /** 
     * 请求消息类型：小视频
     */  
    public static final String REQ_MESSAGE_TYPE_SHORTVIDEO = "shortvideo";
    
    /** 
     * 请求消息类型：推送 
     */  
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";  

    /** 
     * 事件类型：subscribe(订阅 或 用户未关注时，进行关注后的事件推送) 
     */  
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";  

    /** 
     * 事件类型：unsubscribe(取消订阅) 
     */  
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";  

    /** 
     * 事件类型：SCAN(扫描带参数二维码事件,用户已关注时的事件推送) 
     */  
    public static final String EVENT_TYPE_SCAN = "SCAN"; 
    
    /**
     * 事件类型：LOCATION(上报地理位置事件)
     */
    public static final String EVENT_TYPE_LOCATION= "LOCATION"; 
    
    /** 
     * 事件类型：CLICK(自己定义菜单点击事件,点击菜单拉取消息时的事件推送) 
     */  
    public static final String EVENT_TYPE_CLICK = "CLICK"; 
    
    /** 
     * 事件类型：VIEW(自己定义菜单点击事件,点击菜单跳转链接时的事件推送) 
     */  
    public static final String EVENT_TYPE_VIEW = "VIEW"; 
    
    /**
     * 开发者ID-->应用ID
     */
    public static final String APPID = "wxc268fc152fb04c16"; //"wx39bef0f06d28cca8";
    
    /**
     * 开发者ID-->应用密钥
     */
    public static final String APPSECRET = "b428a6487253be2a8342b1865cfddb12"; //"5282954b8381536ad47e25ea5dfe25fe";
    
    /**
     * 接口调用请求: 获取access_token(access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。)
     */
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    
    /**
     * 接口调用请求: 创建菜单
     */
    public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    
    /**
     * 接口调用请求: 菜单查询
     */
    public static final String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    
    /**
     * 接口调用请求: 获取微信服务器IP地址
     */
    public static final String GET_WEIXIN_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
    
    /**
     * 菜单事件：点击菜单的URL
     */
    public static final String MENU_ClICK_URL = "http://jiang13479.51vip.biz/nit2011auto/login/index.jsp";
}
