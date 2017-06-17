package org.sample.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/*
    The example above shows the basic concept of dependency injection, the MessagePrinter
    is decoupled from the MessageService implementation, with Spring Framework wiring
    everything together.
    source: https://projects.spring.io/spring-framework/
 */

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}