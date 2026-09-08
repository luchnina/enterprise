package ru.makhonya.taleKoshchei;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.makhonya.Element;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Profile("koshchei")
public class Needle extends Element {

    private static final String messageKey = "history.needle";

    @Override
    public String getMessage(Locale locale) {
        return messageSourceAccessor.getMessage(messageKey, locale);
    }
}
