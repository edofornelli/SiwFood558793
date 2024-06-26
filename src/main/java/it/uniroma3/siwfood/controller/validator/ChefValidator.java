package it.uniroma3.siwfood.controller.validator;

import it.uniroma3.siwfood.model.Chef;
import it.uniroma3.siwfood.repository.ChefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component  // This annotation allows Spring to automatically detect this class as a Bean and use it as a Validator
public class ChefValidator implements Validator {

    @Autowired
    private ChefRepository chefRepository;

    @Override
    public void validate(Object o, Errors errors) {
        Chef chef = (Chef)o;
        if (chef.getName()!=null && chef.getSurname()!=null && chefRepository.existsByNameAndSurname(chef.getName() , chef.getSurname())){
            errors.reject("chef.duplicate");
        }
    }
    @Override
    public boolean supports(Class<?> aClass) {
        return Chef.class.equals(aClass);
    }

}
