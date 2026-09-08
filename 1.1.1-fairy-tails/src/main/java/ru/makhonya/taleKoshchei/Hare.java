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
public class Hare extends Element {

    @Autowired
    private final Duck duck;

    private static final String messagesKey = "history.hare";

    @Override
    public String getMessage(Locale locale) {
        return duck.getMessage(locale) + " " + messageSourceAccessor.getMessage(messagesKey, locale);
    }
}
