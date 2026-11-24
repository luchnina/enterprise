package ru.makhonya.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
@ComponentScan("ru.makhonya")
@PropertySource(value = "classpath:application.properties",
        ignoreResourceNotFound = true,
        encoding = "UTF-8")
public class ApplicationConfig {

    // Создаём специальный объект Spring,
    // который обрабатывает placeholders вида ${property.name}.
    //
    // Например:
    // @Value("${app.name}")
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // @Value:
    // Spring берёт значение свойства:
    // spring.application.locale.default
    //
    // Если свойство отсутствует, используется значение "en".
    @Bean
    public Locale defaultLocale(
            @Value("${spring.application.locale.default:en}")
            Locale defaultLocale
    ) {
        Locale.setDefault(defaultLocale);
        return defaultLocale;
    }

    @Bean
    public MessageSource messageSource(Locale defaultLocale) {
        // Spring будет использовать этот бин для получения сообщений по ключу.
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        // Spring ищет: messages.properties, messages_ru.properties, messages_en.properties
        messageSource.setBasename("messages");
        // Если для запрошенной локали нет файла, Spring НЕ будет автоматически переключаться на системную локаль ОС.
        messageSource.setFallbackToSystemLocale(false);
        // Если ключ не найден ни в одном подходящем properties-файле,
        // вместо исключения/пустого значения будет возвращён сам ключ.
        //
        // messageSource.getMessage("user.not.found", ...)
        // -> "user.not.found"
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultLocale(defaultLocale);
        return messageSource;
    }

    // → существующий bean для получения локализованных сообщений.
    //
    // Locale defaultLocale
    // → bean Locale, который ты создавал ранее.
    @Bean
    public MessageSourceAccessor messageSourceAccessor(
            MessageSource messageSource,
            Locale defaultLocale
    ) {
        return new MessageSourceAccessor(messageSource, defaultLocale);
    }

    @Configuration
    @Profile("radish")
    @PropertySource(value = "classpath:application-radish.properties",
            ignoreResourceNotFound = true,
            encoding = "UTF-8")
    public static class RadishApplicationConfig {

    }

    @Configuration
    @Profile("koshchei")
    @PropertySource(value = "classpath:application-koshchei.properties",
            ignoreResourceNotFound = true,
            encoding = "UTF-8")
    public static class KoshcheiApplicationConfig {
    }
}
