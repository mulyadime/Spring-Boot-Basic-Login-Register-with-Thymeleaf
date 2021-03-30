/**
 * 
 */
package com.mulyadime.lsp.home;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hamid.mulyadi
 *
 */
@Controller
public class HomeController {
	
	@ModelAttribute("module")
    public String module() {
        return "home";
    }

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Principal principal, Model model) {
		model.addAttribute("pageTitle", "Welcome to LSP!");
		return principal != null ? "/dashboard/home" : "/signin";
	}

}