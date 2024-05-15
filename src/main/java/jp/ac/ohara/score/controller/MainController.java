package jp.ac.ohara.score.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.ac.ohara.score.models.TeacherModel;

@Controller
public class MainController {
	
	@GetMapping("/main/home")
	  public String index(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
	    return "score/home";
	}
}
