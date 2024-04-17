package jp.ac.ohara.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.ac.ohara.score.models.StudentModel;
import jp.ac.ohara.score.repository.StudentRepository;
import jp.ac.ohara.score.service.StudentService;

@Controller
public class StudentController {
	@Autowired
    private StudentService studentService;
	
	@Autowired
    private StudentRepository studentRepository;
	
	// 全学生の情報を取得
	@GetMapping("/main/students")
	public String getAllStudents(Model model) {
		List<StudentModel> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "score/students";
	}
	// 絞り込まれた学生の情報を取得
	@PostMapping("/main/students")
    public String filterStudents(@RequestParam("entYear") Integer entYear,
                                 @RequestParam("classNum") String classNum,
                                 @RequestParam("isAttend") boolean isAttend, Model model) {
        model.addAttribute("students", studentService.filterStudents(entYear, classNum, isAttend));
        return "score/students";
    }
	
	// 新しい学生の情報の登録
	@GetMapping("/main/students/create")
	public String showCreateStudentForm(Model model) {
        model.addAttribute("studentModel", new StudentModel());
        return "score/student_create";
    }
	
	@PostMapping("/main/students/create")
	public String saveStudent(Model model,@ModelAttribute("studentModel") StudentModel studentModel) {
    	studentModel.setIsAttend(true);
		studentService.saveStudent(studentModel);
        return "redirect:/main/students/success";
    }
	
	// 登録完了画面
	@GetMapping("/main/students/success")
	public String success() {
	    return "score/student_create_success";
	}
	

    // 学生の情報変更フォームを表示
    @GetMapping("/main/students/update")
    public String showUpdateStudentForm(@RequestParam Long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "score/student_update";
    }
    @PostMapping("/main/students/update")
    public String updateStudent(@ModelAttribute("student") StudentModel studentModel) {
        studentService.updateStudent(studentModel);
        return "redirect:/main/students/update/success";
    }
    
    // 変更完了画面
 	@GetMapping("/main/students/update/success")
 	public String updateSuccess() {
 	    return "score/student_update_success";
 	}
}
