package bht.salvinto.sfgdi.config;

import bht.salvinto.sfgdi.datasource.FakeDatasource;
import bht.salvinto.sfgdi.repositories.EnglishGreetingRepository;
import bht.salvinto.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import bht.salvinto.sfgdi.services.*;
import bht.salvinto.springframework.pets.PetService;
import bht.salvinto.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDatasource fakeDatasource(@Value("${bht.username}") String username,
                                  @Value("${bht.password}") String password,
                                  @Value("${bht.jdbcUrl}") String jdbcUrl) {
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setUsername(username);
        fakeDatasource.setPassword(password);
        fakeDatasource.setJdbcUrl(jdbcUrl);
        return fakeDatasource;
    }

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
