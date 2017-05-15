package com.fdmgroup;

public class LoginController {

	private View view;
	private Validator validator;
	
	public LoginController(View view, Validator validator){
		this.view = view;
		this.validator = validator;
	}
	
	public void handle(){
		String input = view.getUserInput();
		System.out.println(validator.validate(input));
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
}
