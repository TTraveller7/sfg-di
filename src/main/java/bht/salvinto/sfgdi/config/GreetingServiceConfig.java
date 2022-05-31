package bht.salvinto.sfgdi.config;

import bht.salvinto.sfgdi.services.ConstructorGreetingService;
import bht.salvinto.sfgdi.services.PropertyGreetingService;
import bht.salvinto.sfgdi.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService() {
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService() {
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService() {
        return new SetterGreetingService();
    }
}
