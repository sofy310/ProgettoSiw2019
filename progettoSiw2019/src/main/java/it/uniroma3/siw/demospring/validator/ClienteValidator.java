package it.uniroma3.siw.demospring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demospring.model.Cliente;


@Component 
public class ClienteValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		return Cliente.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "indirizzo", "required");


	}
	
}