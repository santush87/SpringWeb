package bg.softuni.intro.iok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZooConfig {

    @Bean
    public Animal cat(){
        return new Cat();
    }
    @Bean("normalDog")
    public Animal dog(){
        return new Dog();
    }

    @Bean("superDog")
    public Animal superDog(){
        //todo: to add superpower
        return new Dog(true);
    }
}
