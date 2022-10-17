package com.rest.app.security.jwt.worker;

import com.rest.app.general.Worker;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class JwtGetter implements Worker<String> {
    private HttpServletRequest request;

    public Worker<String> payload(HttpServletRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public String execute() {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }
}
