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
public class Grandmother extends Element {

    @Autowired
    private final Granddaughter granddaughter;

    private static final String messageKey = "history.grandmother";

    @Override
    public String getMessage(Locale locale) {
        return granddaughter.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }

}
