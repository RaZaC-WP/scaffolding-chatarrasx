package com.edf.ltihelloworld.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.edf.ltihelloworld.constants.CacheConstants;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableCaching
@EnableScheduling
@Slf4j
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(
            CacheConstants.COURSE_AUTOEVALUATION
            );
        return cacheManager;
    }

    //Evict all the caches every 10 minutes.
    @CacheEvict(allEntries = true, value = { 
    		CacheConstants.COURSE_AUTOEVALUATION
            })
    @Scheduled(fixedDelay =  10 * 60 * 1000,  initialDelay = 500)
    public void cacheEvict() {
        log.info("Evicting caches of the autoevaluation application, the cache is refreshed every 10 minutes.");
    }

}
