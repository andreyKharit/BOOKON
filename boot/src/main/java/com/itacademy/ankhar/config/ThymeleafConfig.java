/*
 * Last updated: 6/28/20, 11:39 PM
 * Author: Andrey Kharitonenko
 */

package com.itacademy.ankhar.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
