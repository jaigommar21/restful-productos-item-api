package pe.edu.tecsup.productositemapi.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;

// PENDIENTE : https://www.nexsoftsys.com/articles/learn-spring-cloud-feign-and-hystrix-circuit-breaker.html

public class FeignConfig {

	// https://stackoverflow.com/questions/35853908/how-to-set-custom-jackson-objectmapper-with-spring-cloud-netflix-feign

//    @Bean
//    public Decoder feignDecoder() {
//        HttpMessageConverter<?> jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
//        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
//    }
//
//    public ObjectMapper customObjectMapper(){
//        ObjectMapper objectMapper = new ObjectMapper();
//        //Customize as much as you want
//        return objectMapper;
//    }

	@Bean
	public Decoder feignDecoder() {
		return new JacksonDecoder();

	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}