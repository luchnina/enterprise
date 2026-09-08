package ru.makhonya.taleTurnip;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.makhonya.Element;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Profile("radish")
public class Cat extends Element {

    @Autowired
    private final Mouse mouse;

    private static final String messageKey = "history.cat";

    @Override
    public String getMessage(Locale locale) {
        return mouse.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }
}
