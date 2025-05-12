package com.codigomaestro.evidencia3.Config;

import com.codigomaestro.evidencia3.Filters.AdminFilter;
import com.codigomaestro.evidencia3.Filters.PacientFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AdminFilter> adminFilter() {
        FilterRegistrationBean<AdminFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AdminFilter());
        registrationBean.addUrlPatterns("/api/admin/*");
        registrationBean.addUrlPatterns("/admin");
        registrationBean.setName("adminFilter");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<PacientFilter> pacientFilter() {
        FilterRegistrationBean<PacientFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new PacientFilter());
        registrationBean.addUrlPatterns("/api/pacient/*");
        registrationBean.addUrlPatterns("/pacient");
        return registrationBean;
    }

}
