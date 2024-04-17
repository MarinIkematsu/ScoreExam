package jp.ac.ohara.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.ohara.score.models.SubjectModel;
import jp.ac.ohara.score.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
    private SubjectService subjectService;
	
	// 科目の一覧表示
	@GetMapping("/main/subjects")
	public String getAllSubjects(Model model) {
		List<SubjectModel> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects);
        return "score/subjects";
	}
	
	
	// 科目の新規登録
	@GetMapping("/main/subjects/create")
	public String showCreateSubjectForm(Model model) {
        model.addAttribute("subjectModel", new SubjectModel());
        return "score/subject_create";
    }
	
	@PostMapping("/main/subjects/create")
	public String saveStudent(Model model,@ModelAttribute("subjectModel") SubjectModel subjectModel) {
		subjectService.saveSubject(subjectModel);
        return "redirect:/main/subjects";
    }
	
	
	// 科目の編集更新
	@GetMapping("/main/subjects/update")
    public String showUpdateSubjectForm(@RequestParam Long id, Model model) {
        SubjectModel subject = subjectService.getSubjectById(id);
        model.addAttribute("subject", subject);
        return "score/subject_update";
    }
    @PostMapping("/main/subjects/update")
    public String updateSubject(@ModelAttribute("subject") SubjectModel subjectModel) {
        subjectService.updateSubject(subjectModel);
        return "redirect:/main/subjects";
    }
    
    
	// 科目の削除
}
