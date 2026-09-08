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
public class Bug extends Element {

    @Autowired
    private final Cat cat;

    private static final String messageKey = "history.bug";

    @Override
    public String getMessage(Locale locale) {
        return cat.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }

}
