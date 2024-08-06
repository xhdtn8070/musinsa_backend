package com.tikim.org.musinsa.global.cache.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GlobalCacheService {

    private final CacheManager cacheManager;

    public void evictAllCaches() {
        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
}
