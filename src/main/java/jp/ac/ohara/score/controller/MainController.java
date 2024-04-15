package jp.ac.ohara.score.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main/home")
	  public String index() {
	    return "score/home";
	}
}
