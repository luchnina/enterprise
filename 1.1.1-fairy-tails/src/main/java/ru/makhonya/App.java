package ru.makhonya;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;
import ru.makhonya.config.ApplicationConfig;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class App {

    static void main() {

        try(var applicationContext = new AnnotationConfigApplicationContext()) {

            var environment = applicationContext.getEnvironment();

            Map<String, Object> properties = new HashMap<>();
            properties.put("spring.profiles.active", "koshchei");
            properties.put("spring.application.locale", "ru");

            environment.getPropertySources().addFirst(
                    new MapPropertySource("properties", properties)
            );

            applicationContext.register(ApplicationConfig.class);
            applicationContext.refresh();

        }

        try(var applicationContext = new AnnotationConfigApplicationContext()) {

            var environment = applicationContext.getEnvironment();

            Map<String, Object> properties = new HashMap<>();
            properties.put("spring.profiles.active", "radish");
            properties.put("spring.application.locale", "ru");

            environment.getPropertySources().addFirst(
                    new MapPropertySource("properties", properties)
            );

            applicationContext.register(ApplicationConfig.class);
            applicationContext.refresh();
        }
    }
}
