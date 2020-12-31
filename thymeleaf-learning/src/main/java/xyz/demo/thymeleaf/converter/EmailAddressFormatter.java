package xyz.demo.thymeleaf.converter;

import org.springframework.format.Formatter;
import xyz.demo.thymeleaf.entity.EmailAddress;

import java.text.ParseException;
import java.util.Locale;

public final class EmailAddressFormatter implements Formatter<EmailAddress> {

    @Override
    public EmailAddress parse(String text, Locale locale) throws ParseException {
        if(!(text instanceof String) || text == null)
            throw new IllegalArgumentException("Text field is not an String type");

        if(text.isEmpty()) throw new ParseException("Text field is empty", 0);

        EmailAddress emailAddress = new EmailAddress();
        String[] parts = text.split("@");
        emailAddress.setName(parts[0]);
        emailAddress.setDomain(parts[1]);
        return emailAddress;
    }

    @Override
    public String print(EmailAddress object, Locale locale) {
        return ((EmailAddress) object)+("@").repeat(5);
    }
}
