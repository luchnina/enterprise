package ru.makhonya.taleKoshchei;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.makhonya.Element;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Profile("koshchei")
public class Duck extends Element {

    @Autowired
    private final Egg egg;

    private static final String messageKey = "history.duck";

    @Override
    public String getMessage(Locale locale) {
        return egg.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }
}
