package com.shivesh.flightreservation.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shive
 *
 */
public class MyErrorController implements ErrorController {

	 @RequestMapping("/error")
	 public String handleError() {
	        return "error";
	}
	 
	@Override
	public String getErrorPath() {
		return "/error";
	}

}
