package bht.salvinto.sfgdi;

import bht.salvinto.sfgdi.config.SfgConfig;
import bht.salvinto.sfgdi.config.SfgConstructorConfig;
import bht.salvinto.sfgdi.controllers.*;
import bht.salvinto.sfgdi.datasource.FakeDatasource;
import bht.salvinto.sfgdi.services.PrototypeBean;
import bht.salvinto.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

// @ComponentScan({"bht.salvinto.sfgdi", "bht.salvinto.springframework"})
@EnableConfigurationProperties(SfgConstructorConfig.class)
@SpringBootApplication
public class SfgDiApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.whichPetIsBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("------ Profile");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController)ctx.getBean("myController");
		System.out.println("------ Primary");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------ Setter");
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------ Constructor");
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("------ Bean scope");
		SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getScope());
		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());
		PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());

		System.out.println("------ Fake Data source");
		FakeDatasource fakeDatasource = ctx.getBean(FakeDatasource.class);
		System.out.println(fakeDatasource.getUsername());
		System.out.println(fakeDatasource.getPassword());
		System.out.println(fakeDatasource.getJdbcUrl());

		System.out.println("------ Config prop bean");
		SfgConfig sfgConfig = ctx.getBean(SfgConfig.class);
		System.out.println(sfgConfig.getUsername());
		System.out.println(sfgConfig.getPassword());
		System.out.println(sfgConfig.getJdbcUrl());

		System.out.println("------ Constructor Config prop bean");
		SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
		System.out.println(sfgConstructorConfig.getUsername());
		System.out.println(sfgConstructorConfig.getPassword());
		System.out.println(sfgConstructorConfig.getJdbcUrl());
	}
}
