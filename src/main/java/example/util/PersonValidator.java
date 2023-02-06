package example.util;

import example.dao.PersonDAO;
import example.models.Person;
import example.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonServiceImpl personServiceImpl;

    @Autowired
    public PersonValidator(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;
        if (personServiceImpl.getPersonByName(person.getName()).isPresent()) {
            errors.rejectValue("Name", "", "Это ФИО уже занято");
        }
    }
}
