package com.gcf.provider.tag.configer;

import java.time.Duration;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfiger extends CachingConfigurerSupport {

	@Bean
	public RedisCacheConfiguration redisCacheConfiguration() {
		//entryTtl配置缓存过期时间
		//serializeKeysWith配置redis中key的序列化处理类
		//serializeValuesWith配置redis中value的序列化处理类
		//注意：如果value中存在map，当前value配置会丢失json数据
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(20))
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
				.serializeValuesWith(RedisSerializationContext.SerializationPair
						.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	@Override
	@Bean
	public CacheErrorHandler errorHandler() {
		// 异常处理，当Redis发生异常时，打印日志，但是程序正常走
		CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
				e.printStackTrace();
			}

			@Override
			public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
				e.printStackTrace();
			}

			@Override
			public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
				e.printStackTrace();
			}

			@Override
			public void handleCacheClearError(RuntimeException e, Cache cache) {
				e.printStackTrace();
			}
		};
		return cacheErrorHandler;
	}
}
