package com.mulyadime.lsp.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@ControllerAdvice
public class ExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest webRequest) {
		ModelAndView model = new ModelAndView();
		Throwable rootCause = Throwables.getRootCause(exception);
		model.addObject("errorMessage", rootCause);
		
		LOGGER.error(rootCause.toString(), exception);
		return model;
	}

}
