package com.jhlee.gateway.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "external-service")
class ApplicationConfig(
    val auth: AddressInfo,
    val member: AddressInfo
) {
    data class AddressInfo(
        val protocol: String,
        val host: String,
        val port: Int
    ) {
        fun getUri(): String {
            return "${this.protocol}${this.host}:${this.port}"
        }
    }
}