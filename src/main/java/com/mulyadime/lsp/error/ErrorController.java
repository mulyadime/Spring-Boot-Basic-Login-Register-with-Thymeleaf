/**
 * 
 */
package com.mulyadime.lsp.error;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Throwables;

/**
 * @author hamid.mulyadi
 *
 */
@Controller
public class ErrorController {
	

	/**
	 * Display an error page, as defined in web.xml <code>custom-error</code> element.
	 */
	@RequestMapping("generalError")
	public String error(HttpServletRequest request, HttpServletResponse response, Model model) {
		String classpath = "javax.servlet.error";
		Integer statusCode = (Integer) request.getAttribute(classpath + ".status_code");
		Throwable throwable= (Throwable) request.getAttribute(classpath + ".exception");
		String exceptionMessage= getExceptionMessage(throwable, statusCode);
		String requestUri  = (String) request.getAttribute(classpath + ".request_uri");
		if (requestUri == null) requestUri = "Unknown";
		
		String message = MessageFormat.format("{0} returned for {1} with message {2}", statusCode, requestUri, exceptionMessage);
		model.addAttribute("errorMessage", message);
		return "error/general";
	}

	private String getExceptionMessage(Throwable throwable, Integer statusCode) {
		if (throwable != null)
			return Throwables.getRootCause(throwable).getMessage();
		
		return HttpStatus.valueOf(statusCode).getReasonPhrase();
	}

}
