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
public class Box extends Element {

    @Autowired
    private final Hare hare;

    private static final String messagesKey = "history.box";

    @Override
    public String getMessage(Locale locale) {
        return hare.getMessage(locale) + " " + messageSourceAccessor.getMessage(messagesKey, locale);
    }
}
