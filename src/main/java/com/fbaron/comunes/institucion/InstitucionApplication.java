package com.fbaron.comunes.institucion;

import com.fbaron.comunes.institucion.config.JpaAuditingConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class InstitucionApplication {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new JpaAuditingConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(InstitucionApplication.class, args);
    }

}
