package jp.ac.ohara.score.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.service.TeacherService;
import jp.ac.ohara.score.service.TeacherSignupService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherSignupService teacherSignupService;
	
	@GetMapping("/login")
    public String showLoginForm(Model model) {
    	model.addAttribute("teacherModel", new TeacherModel());
        return "user/login";
    }
	@PostMapping("/login")
    public String login(String teacherId,String password, HttpSession session) {
	   	 if (teacherService.authenticate(teacherId, password)) {
	         // 認証に成功した場合、セッションを開始してログイン状態にする
	         session.setAttribute("teacherId", teacherId);
	         return "redirect:/main/home"; // ログイン後のリダイレクト先を指定
	     } else {
	         // 認証に失敗した場合はログインフォームに戻す
	    	 System.out.println("認証失敗" + teacherId);
	         return "redirect:/login?error";
	     }
	}
    // サインアップ
    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("teacherModel", new TeacherModel());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("teacherModel") @Validated TeacherModel teacherModel, BindingResult result) {
        // サインアップ処理を実行
    	if (result.hasErrors()) {
            return "user/signup";
        }
        
        // 登録処理を行う
        teacherSignupService.signupTeacher(teacherModel);
        return "redirect:/login"; // ログインページにリダイレクト
    }
    
    
    
    @GetMapping("/logout")
    public String logout() {
        // ログアウト処理を実行
        return "redirect:/login"; // ログインページにリダイレクト
    }

}
