package com;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class Mesconfig {
	@Configuration
	public class MessagesConfig {
		@Bean("messageSource")
		public MessageSource getMessageSource() {
			ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
			ms.setBasenames(
					"classpath:messages/account",
					"classpath:messages/category",
					"classpath:messages/order",
					"classpath:messages/orderdetail",
					"classpath:messages/product"
					);
			ms.setDefaultEncoding("utf-8");
			return ms;
		}
	}
}
