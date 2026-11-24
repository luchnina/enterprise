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
public class Granddaughter extends Element {

    @Autowired
    private final Bug bug;

    private static final String messageKey = "history.granddaughter";

    @Override
    public String getMessage(Locale locale) {
        return bug.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }

}
