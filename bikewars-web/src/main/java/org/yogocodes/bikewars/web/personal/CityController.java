package org.yogocodes.bikewars.web.personal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CityController {

	private final Logger log = LoggerFactory.getLogger(CityController.class);
	
	
	@RequestMapping(value="/personal/cities", method=RequestMethod.GET)
	public String view() {
		log.trace("view cities");
		return "personal/cities";
	}
}
