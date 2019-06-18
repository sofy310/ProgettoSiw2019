package it.uniroma3.siw.demospring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demospring.model.Funzionario;


@Component
public class FunzionarioValidator implements Validator{

	@Override
	public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "userName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Funzionario.class.equals(clazz);
	}

}