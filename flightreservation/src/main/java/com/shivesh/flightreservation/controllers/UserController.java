package com.shivesh.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivesh.flightreservation.entities.Role;
import com.shivesh.flightreservation.entities.User;
import com.shivesh.flightreservation.repos.UserRepository;
import com.shivesh.flightreservation.services.SecurityService;

/**
 * @author shive
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		LOGGER.info("Inside showRegistrationPage()");
		return "login/registerUser";
	}

	/**
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user,ModelMap modelMap) {
		LOGGER.info("Inside register()"+ user);
		user.setPassword(encoder.encode(user.getPassword()));
		modelMap.addAttribute("registerd","You have registered successfully, Please log in to continue");
		userRepository.save(user);
		return "login/login";
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		LOGGER.info("Inside showLoginPage()");
		return "login/login";
	}

	/**
	 * @param email
	 * @param password
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		LOGGER.info("Inside login() and the email is: {}",email);
		try {
		User user = userRepository.findByEmail(email);
		if(user != null && !user.getRoles().isEmpty() && securityService.login(email, password)) {
			for(Role role:user.getRoles()) {
				if(role.getName().equals("ADMIN")) {
					modelMap.addAttribute("user", user);
					return "addFlight";
				}
			}
		}else {
			modelMap.addAttribute("msg", "Invalid Username/Password. Please try again!");
		}
		
		boolean loginResponse = false;

		
		loginResponse = securityService.login(email, password);
		
		if (loginResponse) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid Username/Password. Please try again!");

		}
		}catch(Exception exception) {
			modelMap.addAttribute("msg", "Invalid Username/Password. Please try again!");
		}
		return "login/login";
	}
	
	@RequestMapping(value = "/searchFlights", method = RequestMethod.GET)
	public String findFlightsPage() {

		return "findFlights";
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {

		return "login/login";
	}
}
