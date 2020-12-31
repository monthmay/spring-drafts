package xyz.demo.thymeleaf.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import xyz.demo.thymeleaf.entity.People;

public final class PeopleValidator implements Validator {

    private final int MIN_AGE = 18, MAX_AGE = 100;
    private final int MIN_NAME_LENGTH = 3, MAX_NAME_LENGTH = 255;
    private final String EMAIL_REGEXP = "^(?i)\\w{3,}@\\w{3,}\\.\\w{3,}$";
    private final String PHONE_REGEXP = "^\\+\\d{2,3} ?\\(\\d{2,3}\\) ?9\\d{4}-\\d{4}$";

    @Override
    public boolean supports(Class<?> clazz) {
        return People.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        People people = (People) target;

        if(people.getName() == null || people.getName().isEmpty())
            errors.rejectValue("name", "name.empty", "Name field can not be empty");
        else if(people.getName().length() < MIN_NAME_LENGTH)
            errors.rejectValue("name", "name.too.small", "Name field can not be too small");
        else if(people.getName().length() > MAX_NAME_LENGTH)
            errors.rejectValue("name", "name.too.long", "Name field can not be too long");

        if(people.getEmailAddress() == null)
            errors.rejectValue("emailAddress", "email.null", "Email needs be specified");
        else if(!(people.getEmailAddress()+"").matches(EMAIL_REGEXP))
            errors.rejectValue("emailAddress", "email.invalid", "Email needs be valid");

        if(people.getAge() < MIN_AGE)
            errors.rejectValue("age", "age.too.small", "Age field can not be too small");
        else if(people.getAge() > MAX_AGE)
            errors.rejectValue("age", "age.too.long", "Age field can not be too long");

        if(people.getPhone() == null)
            errors.rejectValue("phone", "phone.null", "Phone field needs be specified");
        else if(!people.getPhone().matches(PHONE_REGEXP))
            errors.rejectValue("phone", "phone.invalid", "Phone field needs be valid");

        if(people.getSex() == null)
            errors.rejectValue("sex", "sex.null", "Sex field can not be empty");
    }
}
