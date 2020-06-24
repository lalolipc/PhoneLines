package com.utn.PhoneLines.configuration;

import com.utn.PhoneLines.session.AntennaSessionFilter;
import com.utn.PhoneLines.session.BackofficeSessionFilter;
import com.utn.PhoneLines.session.SessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@org.springframework.context.annotation.Configuration
@PropertySource("application.properties")
public class Configuration {

    @Autowired
    SessionFilter sessionFilter;
    @Autowired
    AntennaSessionFilter antennaSessionFilter;
    @Autowired
    BackofficeSessionFilter backofficeSessionFilter;

    @Bean
    public FilterRegistrationBean clientFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter);
        registration.addUrlPatterns("/api/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean backofficeFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(backofficeSessionFilter);
        registration.addUrlPatterns("/backoffice/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean antennaFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(antennaSessionFilter);
        registration.addUrlPatterns("/antenna/*");
        return registration;
    }

}
