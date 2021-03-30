/**
 * 
 */
package com.mulyadime.lsp.account;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hamid.mulyadi
 *
 */
@Controller
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	private final String BASE_URL = "account";
	
	@RequestMapping(method = RequestMethod.GET, value = BASE_URL + "/current")
	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public Account currentAccount(Principal principal) {
		return accountRepository.findOneByUsername(principal.getName());
	}
	

}
