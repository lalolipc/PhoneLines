package com.utn.PhoneLines.configuration;

import com.utn.PhoneLines.session.InfraestructureFilter;
import com.utn.PhoneLines.session.BackofficeSessionFilter;
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
    InfraestructureFilter infraestructureFilter;
    @Autowired
    BackofficeSessionFilter backofficeSessionFilter;
    /*
        @Bean
        public FilterRegistrationBean backofficeFilter() {
            FilterRegistrationBean backoffice = new FilterRegistrationBean();
            backoffice.setFilter(employeeSessionFilter);
            backoffice.addUrlPatterns("/backoffice/*");
            return backoffice;
        }*/
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
        antena.setFilter(infraestructureFilter);
        antena.addUrlPatterns("/infraestructure/*");
        return antena;
    }

}
