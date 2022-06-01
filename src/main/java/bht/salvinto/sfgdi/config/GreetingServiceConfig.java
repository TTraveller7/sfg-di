package bht.salvinto.sfgdi.config;

import bht.salvinto.sfgdi.repositories.EnglishGreetingRepository;
import bht.salvinto.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import bht.salvinto.sfgdi.services.*;
import bht.salvinto.springframework.pets.PetService;
import bht.salvinto.springframework.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile("cat")
    @Bean
    PetService catService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Profile("dog")
    @Bean
    PetService dogService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    // @Bean
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

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean
    I18nSpanishGreetingService i18nService() {
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepositoryImpl englishGreetingRepositoryImpl() {
        return new EnglishGreetingRepositoryImpl();
    }
}
