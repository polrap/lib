package com.test.book.controller;




import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.test.book.model.BookRequest;

public class BookRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return BookRequest.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BookRequest bookReq =(BookRequest)target;
		
		if(bookReq.getImage()==null ||bookReq.getImage().isEmpty()) {
			errors.rejectValue("image", "required");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required");
	}

}
