package com.springone.ehcache.javaconfig;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * JavaConfig's CacheManager with spring API
 * 
 * @author Thanooj Kalathuru
 *
 */
@Configuration
@EnableCaching
@ComponentScan({ "com.springone.ehcache.*" })
public class JavaConfig {

	@Bean
	public CacheManager cacheManager() {
		EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager(ehCacheCacheManager().getObject());
		return ehCacheCacheManager;
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}

}
