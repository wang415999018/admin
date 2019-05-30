package com.admin.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 记录当前request，方便在整个生命周期使用 */
public class CurrentRequest {

	private static final ThreadLocal<HttpServletRequest> CURRENT_REQUEST = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> CURRENT_RESPONSE = new ThreadLocal<HttpServletResponse>();

	public static HttpServletRequest getRequest() {
		HttpServletRequest request = CURRENT_REQUEST.get();
		return request;
	}

	public static HttpServletResponse getResponse() {
		HttpServletResponse response = CURRENT_RESPONSE.get();
		return response;
	}

	public static void setRequest(HttpServletRequest request) {
		CURRENT_REQUEST.set(request);
	}

	public static void setResponse(HttpServletResponse response) {
		CURRENT_RESPONSE.set(response);
	}

	public static void clear() {
		CURRENT_REQUEST.remove();
	}
}
