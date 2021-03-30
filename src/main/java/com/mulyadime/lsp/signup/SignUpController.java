/**
 * 
 */
package com.mulyadime.lsp.signup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mulyadime.lsp.account.Account;
import com.mulyadime.lsp.account.AccountService;

/**
 * @author hamid.mulyadi
 *
 */
@Controller
public class SignUpController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpController.class);
	
	private static final String SIGNUP_VIEW_NAME= "/signup";
	private static final String REDIRECT_PATH 	= "redirect:/";
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "/signup")
	public String signUp(Model model) {
		model.addAttribute("pageTitle", "LSP - Register Page");
		model.addAttribute("signUpForm", new SignUpForm());
		return SIGNUP_VIEW_NAME;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public String signUp(@Validated SignUpForm signUpForm, Errors errors, RedirectAttributes ra) {
		LOGGER.debug("{}", signUpForm.toString());
		if (errors.hasErrors())
			return SIGNUP_VIEW_NAME;
		
		Account account = accountService.save(createAccount(signUpForm));
		accountService.signIn(account);
		return REDIRECT_PATH;
	}

	private Account createAccount(SignUpForm form) {
		return new Account(form.getUsername(), form.getPassword(), "ROLE_USER");
	}

}
