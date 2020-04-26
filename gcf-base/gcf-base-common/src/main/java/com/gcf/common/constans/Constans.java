package com.gcf.common.constans;

public interface Constans {

	//服务授权header key
	public static final String SERVERAUTH_HEADER = "server-auth";
	
	//用户授权header key
	public static final String CLIENTAUTH_HEADER = "Authorization";
	
	/**
	 * zuul过滤类型
	 * @author Administrator
	 *
	 */
	public interface ZuulFilterType{
		//请求被路由之前调用
		public static final String PRE_TYPE = "pre";
		//route和error过滤器之后被调用
		public static final String POST_TYPE = "post";
		//请求时发生错误时被调用
		public static final String ERROR_TYPE = "error";
		//路由请求时候被调用
		public static final String ROUTE_TYPE = "route";
	}
	
	public interface JwtResource{
		//缺省的主题
		public static final String DEFAULT_SUBJECT = "server auth";
		//缺省的发布者
		public static final String DEFAULT_ISSUER = "gcf";
		//缺省的授权密码
		public static final String DEFAULT_SECURY = "gcf";
		
	}
}
