package org.yogocodes.bikewars.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.yogocodes.bikewars.errors.ResourceNotFoundException;

public abstract class AbstractBaseController {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@ExceptionHandler
	public void handleException(final Exception cause, final HttpServletRequest request, final HttpServletResponse response) {

		if (cause instanceof ResourceNotFoundException) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		} else {
			log.error("Unhandled exception occurred:{}", cause.getMessage(), cause);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
