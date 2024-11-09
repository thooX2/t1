package ks52team01.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@GetMapping("/")
    public String moveIntro() {
    	log.info("초기 페이지 이동");
    	return "view/home/intro";
	}
	
	@GetMapping("/index")
    public String getProductsList() {
    	log.info("index 페이지 이동");
        return  "view/home/index";
    }
	
	@GetMapping("/aboutUs")
	public String moveAboutUs() {
		log.info("aboutUs 페이지 이동");
		return "view/home/aboutUs";
	}
}
