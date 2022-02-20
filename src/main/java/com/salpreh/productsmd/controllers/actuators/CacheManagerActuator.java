package com.salpreh.productsmd.controllers.actuators;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;

@Component
@RestControllerEndpoint(id = "cache-manager")
@RequiredArgsConstructor
public class CacheManagerActuator {

    private final CacheManager cacheManager;

    @GetMapping
    public ResponseEntity<Collection<String>> listCaches() {
        return ResponseEntity.ok(
            cacheManager.getCacheNames()
        );
    }

    @GetMapping("/{cache}")
    public ResponseEntity<Cache> listCacheKeys(@PathVariable String cache) {
        return ResponseEntity.of(Optional.ofNullable(
            cacheManager.getCache(cache)
        ));
    }

    @GetMapping("{cache}/{key}")
    public ResponseEntity getCacheKeyValue(@PathVariable String cache, @PathVariable String key) {
        return ResponseEntity.of(
            Optional.ofNullable(cacheManager.getCache(cache))
                .map(c -> c.get(key))
        );
    }
}
