package com.utn.PhoneLines.session;

import com.utn.PhoneLines.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class InfraestructureFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        filterChain.doFilter(request, response);
/*
 String authorization = request.getHeader("Authorization");

        if ("antennapassword8232".equals(authorization)) {
            filterChain.doFilter(request, response);
        } else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }*/
    }



}