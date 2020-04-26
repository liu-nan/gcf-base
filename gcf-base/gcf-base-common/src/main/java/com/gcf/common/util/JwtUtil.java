package com.gcf.common.util;

import java.util.ArrayList;
import java.util.List;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gcf.common.constans.Constans;

public class JwtUtil {
	private static List<String> apps = new ArrayList<>();
	static {
		apps.add("gcf-gateway-web");
		apps.add("gcf-gateway-public");
		apps.add("gcf-gateway-mobile");
		apps.add("gcf-provider-user");
		apps.add("gcf-provider-permission");
	}

	public static String getToken(String userId, String password) {
		return JWT.create().withSubject(Constans.JwtResource.DEFAULT_SUBJECT)
				.withIssuer(Constans.JwtResource.DEFAULT_ISSUER).withClaim("userId", userId).withAudience(userId).sign(Algorithm.HMAC256(password));
	}

	public static String getToken(String userId) {
		return getToken(userId, Constans.JwtResource.DEFAULT_SECURY);
	}

	public static boolean checkToken(String token) {
		DecodedJWT decode = JWT.decode(token);
		System.out.println(decode.getSubject().equals(Constans.JwtResource.DEFAULT_SUBJECT));
		System.out.println(apps.contains(decode.getClaim("userId").toString()));
		System.out.println(apps.contains(decode.getClaim("userId").asString()));
		System.out.println(decode.getClaim("userId"));
		return decode.getSubject().equals(Constans.JwtResource.DEFAULT_SUBJECT) && apps.contains(decode.getClaim("userId").asString());
	}
}
