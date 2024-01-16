package com.jhlee.gateway.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouterConfig(
    private val applicationConfig: ApplicationConfig
) {
    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route("member-router") { predicate ->
                predicate.path("/member/**")
                    .uri(applicationConfig.member.getUri())
            }
            .build()
    }
}
