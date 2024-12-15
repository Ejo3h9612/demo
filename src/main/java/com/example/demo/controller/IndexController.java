package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.dto.CustomerDetailsDTO;
import com.example.demo.service.CustomerInfoService;

@Controller
@SessionAttributes("customerId")
public class IndexController {

	@Autowired
    private CustomerInfoService customerInfoService;
	
	@RequestMapping("/index")
	public String index(Model model) throws Exception {

		List<CustomerDetailsDTO> customers = customerInfoService.findCustomerDetails();

		model.addAttribute("customers", customers); // 將數據加入模型
		
		return "index.html";
	}

	@GetMapping("/redirect-to-contacts")
	public String redirectToContacts(@RequestParam int customerId, Model model) {

		model.addAttribute("customerId", customerId);

		return "contacts.html";
	}

	@GetMapping("/redirect-to-tags")
	public String redirectToTags(@RequestParam int customerId, Model model) {

		model.addAttribute("customerId", customerId);

		return "tags.html";
	}
}