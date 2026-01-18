package com.zachprogramming.carcomparisonwebsite.Config;

import org.hibernate.annotations.DialectOverride;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        // redirects the root to swagger until I make the frontend
        registry.addRedirectViewController("/", "/swagger-ui/index.html");
    }
}
