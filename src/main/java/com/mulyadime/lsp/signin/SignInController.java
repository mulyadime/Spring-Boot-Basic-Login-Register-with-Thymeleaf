/**
 * 
 */
package com.mulyadime.lsp.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hamid.mulyadi
 *
 */
@Controller
public class SignInController {
	
	private static final String SIGNIN_VIEW_NAME = "/signin";

	@RequestMapping(method = RequestMethod.GET, value = "/signin")
	public String signIn(Model model) {
		model.addAttribute("pageTitle", "LSP - Login Page");
		return SIGNIN_VIEW_NAME;
	}

}
