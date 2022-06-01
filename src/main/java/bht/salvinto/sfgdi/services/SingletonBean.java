package bht.salvinto.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a singleton bean...");
    }

    public String getScope() {
        return "I am a singleton";
    }
}
