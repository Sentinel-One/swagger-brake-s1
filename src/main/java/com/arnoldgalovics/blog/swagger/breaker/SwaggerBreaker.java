package com.arnoldgalovics.blog.swagger.breaker;

import com.arnoldgalovics.blog.swagger.breaker.core.BreakingChange;
import com.arnoldgalovics.blog.swagger.breaker.core.SwaggerBreakerCoreConfiguration;
import com.arnoldgalovics.blog.swagger.breaker.runner.SwaggerBreakerRunner;
import com.arnoldgalovics.blog.swagger.breaker.runner.SwaggerBreakerRunnerConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.System.out;

public class SwaggerBreaker {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SwaggerBreakerCoreConfiguration.class, SwaggerBreakerRunnerConfiguration.class);
        SwaggerBreakerRunner executor = context.getBean(SwaggerBreakerRunner.class);
        executor.execute("F:\\work\\git\\swagger-breaker\\src\\test\\resources\\pathdeletion\\petstore.yaml", "F:\\work\\git\\swagger-breaker\\src\\test\\resources\\pathdeletion\\petstore_v2.yaml")
                .stream().map(BreakingChange::getMessage).forEach(out::println);
    }
}
