package com.utn.PhoneLines.configuration;

import com.utn.PhoneLines.session.CallFilter;
import com.utn.PhoneLines.session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
public class Configuration {

    @Autowired
    SessionFilter sessionFilter;
    @Autowired
    CallFilter callFilter;

    @Bean
    public FilterRegistrationBean userFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean antennaFilter() {
        FilterRegistrationBean antena = new FilterRegistrationBean();
        antena.setFilter(callFilter);
        antena.addUrlPatterns("/antenna/*");
        return antena;
    }
}
