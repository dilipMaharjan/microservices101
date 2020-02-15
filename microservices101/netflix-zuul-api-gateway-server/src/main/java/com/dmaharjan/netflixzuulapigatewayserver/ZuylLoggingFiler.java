package com.dmaharjan.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuylLoggingFiler extends ZuulFilter {

	private Logger looger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {

		return true; // filter every request
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		looger.info("<<>>Request {} : Request URI {}<<>>", request, request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {

		return "pre"; // filter before every request
	}

	@Override
	public int filterOrder() {

		return 1; // order of priority
	}

}
