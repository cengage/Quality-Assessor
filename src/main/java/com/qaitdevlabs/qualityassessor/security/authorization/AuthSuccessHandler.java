package com.qaitdevlabs.qualityassessor.security.authorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private String userUrl;
	private String adminUrl;

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

	public void setAdminUrl(String adminUrl) {
		this.adminUrl = adminUrl;
	}

	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println(auth.getAuthorities());
		if (auth.getAuthorities().contains("ROLE_ADMIN")) {
			return adminUrl;
		} else if (auth.getAuthorities().contains("ROLE_USER")) {
			return userUrl;
		} else {
			return super.determineTargetUrl(request, response);
		}
	}
}
