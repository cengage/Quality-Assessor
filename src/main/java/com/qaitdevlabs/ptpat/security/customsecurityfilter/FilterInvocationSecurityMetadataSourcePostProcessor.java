package com.qaitdevlabs.ptpat.security.customsecurityfilter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component
public class FilterInvocationSecurityMetadataSourcePostProcessor implements
		BeanPostProcessor {

	@Autowired
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof FilterSecurityInterceptor) {
			((FilterSecurityInterceptor) bean)
					.setSecurityMetadataSource(securityMetadataSource);
		}
		return bean;
	}

	/**
	 * Setter method for injecting dependency of securityMetadataSource
	 * 
	 * @param securityMetadataSource
	 */
	public void setSecurityMetadataSource(
			FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

}
