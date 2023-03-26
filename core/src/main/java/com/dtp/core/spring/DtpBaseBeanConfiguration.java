package com.dtp.core.spring;

import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.constant.DynamicTpConst;
import com.dtp.common.properties.DtpProperties;
import com.dtp.core.DtpRegistry;
import com.dtp.core.monitor.DtpEndpoint;
import com.dtp.core.monitor.DtpMonitor;
import com.dtp.core.support.DtpBannerPrinter;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * DtpBaseBeanConfiguration related
 *
 * @author yanhom
 * @since 1.0.0
 **/
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(DtpProperties.class)
public class DtpBaseBeanConfiguration {

    @Bean
    public ApplicationContextHolder dtpApplicationContextHolder() {
        return new ApplicationContextHolder();
    }

    @Bean
    @ConditionalOnProperty(name = DynamicTpConst.BANNER_ENABLED_PROP, matchIfMissing = true, havingValue = "true")
    public DtpBannerPrinter dtpBannerPrinter() {
        return new DtpBannerPrinter();
    }

    @Bean
    @DependsOn({"dtpApplicationContextHolder"})
    public DtpPostProcessor dtpPostProcessor() {
        return new DtpPostProcessor();
    }

    @Bean
    public DtpRegistry dtpRegistry() {
        return new DtpRegistry();
    }

    @Bean
    public DtpMonitor dtpMonitor() {
        return new DtpMonitor();
    }

    @Bean
    @ConditionalOnAvailableEndpoint
    public DtpEndpoint dtpEndpoint() {
        return new DtpEndpoint();
    }

}