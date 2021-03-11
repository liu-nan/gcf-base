package com.gcf.provider.tag.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.gcf.common.bean.ResponseData;
import com.gcf.common.constans.Constans;
import com.gcf.common.util.JwtUtil;

public class AuthorizeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setCharacterEncoding("UTF-8");
		httpResponse.setContentType("application/json; charset=utf-8");
		String token = httpRequest.getHeader(Constans.SERVERAUTH_HEADER);
		System.out.println("filter in");
		System.out.println("filter auth:"+token);
		System.out.println(httpRequest.getAttribute("userId"));;
		

		if(!JwtUtil.checkToken(token)) {
			PrintWriter print = httpResponse.getWriter();
			print.write(JSONObject.toJSONString(ResponseData.fail("无效的授权")));
			return;
		}
		//验证授权
//		try {
//			ServiceTokenUtil util = ServiceTokenUtil.getInstance("0123456789ABCDEFFEDCBA9876543210");
//			if (util.checkToken("WEB", auth)) {
//				PrintWriter print = httpResponse.getWriter();
//				print.write(ResponseData.fail("无效的授权").toString());
//				return;
//			}
//		} catch (GcfException e) {
//			PrintWriter print = httpResponse.getWriter();
//			print.write(ResponseData.fail("无效的授权").toString());
//			return;
//		}
		chain.doFilter(httpRequest, response);

	}

}
