package jp.ac.ohara.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.ac.ohara.score.models.ClassModel;
import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.service.ClassService;

@Controller
public class ClassController {
	@Autowired
    private ClassService classService;
	
	// クラスの追加登録
	@GetMapping("/main/classes/create")
	public String showCreateClassForm(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
		ClassModel classModel = new ClassModel();
		// ログインしている教師の学校コードをGET・SET
		classModel.setSchoolCd(teacher.getSchoolCd());
		model.addAttribute("schoolCd", teacher.getSchoolCd());
		model.addAttribute("classModel", classModel);
        return "score/classes/class_create";
    }
	
	@PostMapping("/main/classes/create")
	public String saveClass(Model model,@ModelAttribute("classModel") ClassModel classModel) {
		classService.saveClass(classModel);
        return "redirect:/main/classes/success";
    }
	
	// 登録完了画面
	@GetMapping("/main/classes/success")
	public String success(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
	    return "score/classes/class_create_success";
	}
}
