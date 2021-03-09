//package com.gcf.gateway.web.configer;
//
//import org.springframework.beans.factory.annotation.Value;
//
//import com.gcf.common.constans.Constans;
//import com.gcf.common.util.JwtUtil;
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//public class ServerAuthFilter extends ZuulFilter {
//
//	@Value("${spring.application.name}")
//	private String appName;
//
//	@Override
//	public boolean shouldFilter() {
//		return true;
//	}
//
//	@Override
//	public Object run() throws ZuulException {
//		System.out.println("zuul filter in");
//		RequestContext ctx = RequestContext.getCurrentContext();
//		System.out.println("appname : " + appName);
//		ctx.addZuulRequestHeader(Constans.SERVERAUTH_HEADER, JwtUtil.getToken(appName));
//		return null;
//	}
//
//	@Override
//	public String filterType() {
//		return Constans.ZuulFilterType.PRE_TYPE;
//	}
//
//	@Override
//	public int filterOrder() {
//		return 1;
//	}
//
//}
