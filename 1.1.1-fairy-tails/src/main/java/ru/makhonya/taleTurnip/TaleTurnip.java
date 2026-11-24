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
public class TaleTurnip extends Element {

    @Autowired
    private final Grandfather grandfather;

    private static final String messageKey = "history.turnip";

    @Override
    public String getMessage(Locale locale) {
        return grandfather.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }

}
