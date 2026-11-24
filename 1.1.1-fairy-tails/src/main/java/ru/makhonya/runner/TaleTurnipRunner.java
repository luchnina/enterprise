package ru.makhonya.runner;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.makhonya.taleTurnip.TaleTurnip;

import java.util.Locale;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
@Profile("radish")
public class TaleTurnipRunner
        implements ApplicationListener<ContextRefreshedEvent> {

    private final TaleTurnip taleTurnip;

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {

        Locale locale = Locale.forLanguageTag(
                Objects.requireNonNull(
                        event.getApplicationContext().getEnvironment().getProperty("spring.application.locale")
                )
        );

        log.info(taleTurnip.getMessage(locale));
    }
}
