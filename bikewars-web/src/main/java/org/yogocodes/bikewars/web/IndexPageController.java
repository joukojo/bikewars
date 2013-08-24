package org.yogocodes.bikewars.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexPageController {
	private final Logger log = LoggerFactory.getLogger(IndexPageController.class);
	
	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public String view() {
		log.trace("view"); 
		return "index";
	}
}
