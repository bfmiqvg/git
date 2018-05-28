package com.example.test.config;

import com.example.test.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date:Created by luzy on 2018/4/24.
 * @Description: 代码实现过滤器配置
 */
@Configuration
public class FilterConfig {
  /*  @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LoginFilter());
        frBean.addUrlPatterns("/**");
        return frBean;
    }*/
}
