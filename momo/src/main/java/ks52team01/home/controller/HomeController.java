package ks52team01.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
    public String getProductsList(Model model) {
    	System.out.println("index 페이지 이동");
        return  "view/home/index";
    }
	
	@GetMapping("/aboutUs")
	public String moveAboutUs() {
		System.out.println("test move");
		return "view/home/aboutUs";
	}
}
