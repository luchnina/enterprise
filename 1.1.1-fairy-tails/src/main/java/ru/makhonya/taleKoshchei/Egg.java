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
public class Egg extends Element {

    @Autowired
    private final Needle needle;

    private static final String messageKey = "history.egg";

    @Override
    public String getMessage(Locale locale) {
        return needle.getMessage(locale) + " " + messageSourceAccessor.getMessage(messageKey, locale);
    }
}
