package com.uiuc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/davisMain")
public class DavisMainController {
	public DavisMainController() {

	}

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}
}
