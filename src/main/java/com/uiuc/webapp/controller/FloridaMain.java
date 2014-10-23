package com.uiuc.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/floridaMain")
public class FloridaMain {
	public FloridaMain() {

	}

	@RequestMapping(method = RequestMethod.GET)
	public void displayCharts() {

	}
}
