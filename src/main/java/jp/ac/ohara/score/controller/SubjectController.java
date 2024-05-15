package jp.ac.ohara.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.ohara.score.models.SubjectModel;
import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
    private SubjectService subjectService;
	//@Autowired
    //private SchoolService schoolService;
	
// ログインした教師のschoolCdに一致する科目の一覧表示
	@GetMapping("/main/subjects")
	public String getAllSubjects(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
		String schoolCd = teacher.getSchoolCd();
	    List<SubjectModel> subjects = subjectService.getAllSubjectsBySchoolCd(schoolCd);
	    model.addAttribute("subjects", subjects);
        return "score/subject/subjects";
	}
	
	
// 科目の新規登録
	@GetMapping("/main/subjects/create")
	public String showCreateSubjectForm(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
		SubjectModel subjectModel = new SubjectModel();
		subjectModel.setSchoolCd(teacher.getSchoolCd());
		model.addAttribute("schoolCd", teacher.getSchoolCd());
        model.addAttribute("subjectModel", subjectModel);
        return "score/subject/subject_create";
    }
	
	@PostMapping("/main/subjects/create")
	public String saveStudent(Model model,@ModelAttribute("subjectModel") SubjectModel subjectModel) {
		subjectService.saveSubject(subjectModel);
        return "redirect:/main/subjects/success";
    }
// 登録完了画面
	@GetMapping("/main/subjects/success")
	public String success(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
	    return "score/subject/subject_create_success";
	}
	
	
// 科目の編集更新
	@GetMapping("/main/subjects/update")
    public String showUpdateSubjectForm(@RequestParam Long id, Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
        SubjectModel subject = subjectService.getSubjectById(id);
        subject.setSchoolCd(teacher.getSchoolCd());
        model.addAttribute("subject", subject);
        return "score/subject/subject_update";
    }
    @PostMapping("/main/subjects/update")
    public String updateSubject(@ModelAttribute("subject") SubjectModel subjectModel) {
        subjectService.updateSubject(subjectModel);
        return "redirect:/main/subjects/update/success";
    }
// 編集更新完了画面
 	@GetMapping("/main/subjects/update/success")
 	public String updateSuccess(Model model, @AuthenticationPrincipal TeacherModel teacher) {
 		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
 	    return "score/subject/subject_update_success";
 	}
    
    
// 科目の削除
    @GetMapping("/main/subjects/delete")
    public String showDeleteSubjectForm(@RequestParam Long id, Model model,@AuthenticationPrincipal TeacherModel teacher) {
    	String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
    	SubjectModel subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "score/subject/subject_delete";
    }

    @PostMapping("/main/subjects/delete")
    public String deleteSubject(@ModelAttribute("subject") SubjectModel subjectModel) {
        subjectService.deleteSubject(subjectModel);
        return "redirect:/main/subjects/delete/success";
    }
    
// 削除完了画面
 	@GetMapping("/main/subjects/delete/success")
 	public String deleteSuccess(Model model, @AuthenticationPrincipal TeacherModel teacher) {
 		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
 	    return "score/subject/subject_delete_success";
 	}
}





/*
  // 科目の一覧表示
	@GetMapping("/main/subjects")
	public String getAllSubjects(Model model) {
		List<SubjectModel> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "score/subjects";
	}
*/
