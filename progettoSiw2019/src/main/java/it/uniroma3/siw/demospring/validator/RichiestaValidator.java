package it.uniroma3.siw.demospring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demospring.model.Richiesta;

public class RichiestaValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Richiesta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
		
	}

}