package org.zenika.skillz.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.zenika.skillz")
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        List<MediaType> mediatypes = new ArrayList<MediaType>();
        mediatypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediatypes);
        converters.add(converter);
    }


    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }


}