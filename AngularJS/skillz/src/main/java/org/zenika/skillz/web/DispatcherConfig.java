package org.zenika.skillz.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.hal.Jackson1HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages="org.zenika.skillz.web")
public class DispatcherConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
        List<MediaType> mediatypes = new ArrayList<MediaType>();
        mediatypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediatypes);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jackson1HalModule());

        converter.setObjectMapper(objectMapper);
        converters.add(converter);
    }


    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }


}