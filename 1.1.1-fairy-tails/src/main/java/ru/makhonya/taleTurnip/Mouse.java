package ru.makhonya.taleTurnip;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.makhonya.Element;

import java.util.Locale;

@Component
@Profile("radish")
public class Mouse extends Element {

    private static final String messageKey = "history.mouse";

    @Override
    public String getMessage(Locale locale) {
        return messageSourceAccessor.getMessage(messageKey, locale);
    }
}
