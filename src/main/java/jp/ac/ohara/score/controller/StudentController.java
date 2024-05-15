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

import jp.ac.ohara.score.models.ClassModel;
import jp.ac.ohara.score.models.StudentModel;
import jp.ac.ohara.score.models.TeacherModel;
import jp.ac.ohara.score.repository.StudentRepository;
import jp.ac.ohara.score.service.ClassService;
import jp.ac.ohara.score.service.StudentService;

@Controller
public class StudentController {
	@Autowired
    private StudentService studentService;
	@Autowired
    private ClassService classService;
	@Autowired
    private StudentRepository studentRepository;
	
	// ログインしている教師のschoolCdに一致する全学生の情報を取得
	@GetMapping("/main/students")
	public String getAllStudents(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		
		// 一覧表示＋絞り込みに表示される学生をログイン中の教師のschoolCdに一致するものに絞る
		String schoolCd = teacher.getSchoolCd();
	    List<StudentModel> students = studentService.getAllStudentsBySchoolCd(schoolCd);
	    // 絞り込み時のプルダウンに使用するクラス番号
	    List<ClassModel> classnums = classService.getAllClassNumsBySchoolCd(schoolCd);
        model.addAttribute("students", students);
        model.addAttribute("classNums", classnums);
        return "score/student/students";
	}
	// 絞り込まれた学生の情報を取得
	@PostMapping("/main/students")
    public String filterStudents(@RequestParam(name ="entYear", required = false) Integer entYear,
                                 @RequestParam(name = "classNum", required = false) String classNum,
                                 @RequestParam(name = "isAttend", required = false) boolean isAttend, Model model) {
        model.addAttribute("students", studentService.filterStudents(entYear, classNum, isAttend));
        return "score/student/students";
    }
	
	// 新しい学生の情報の登録
	@GetMapping("/main/students/create")
	public String showCreateStudentForm(Model model, @AuthenticationPrincipal TeacherModel teacher) {
		// ログイン中の教師の名前を取得
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
		// ログイン中の教師の学校コードを取得
		String schoolCd = teacher.getSchoolCd();
		// ログイン中の教師の学校コードに一致するクラス番号を取得
		List<ClassModel> classnums = classService.getAllClassNumsBySchoolCd(schoolCd);
		// new StudentModelで先ほど取得した学校コードをStudentModelに追加する
		StudentModel studentModel = new StudentModel();
		studentModel.setSchoolCd(teacher.getSchoolCd());
		// modelに追加（？）
	    model.addAttribute("schoolCd", teacher.getSchoolCd());
	    model.addAttribute("classNums", classnums);
	    model.addAttribute("studentModel", studentModel);
        return "score/student/student_create";
    }
	
	
	@PostMapping("/main/students/create")
	public String saveStudent(Model model,@ModelAttribute("studentModel") StudentModel studentModel) {
    	studentModel.setIsAttend(true);
		studentService.saveStudent(studentModel);
        return "redirect:/main/students/success";
    }
	
	// 登録完了画面
	@GetMapping("/main/students/success")
	public String success(Model model,@AuthenticationPrincipal TeacherModel teacher) {
		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
	    return "score/student/student_create_success";
	}
	

    // 学生の情報変更フォームを表示
    @GetMapping("/main/students/update")
    public String showUpdateStudentForm(@RequestParam Long id, Model model, @AuthenticationPrincipal TeacherModel teacher) {
    	String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
    	
        StudentModel student = studentService.getStudentById(id);
        student.setSchoolCd(teacher.getSchoolCd());
        model.addAttribute("student", student);
        return "score/student/student_update";
    }
    @PostMapping("/main/students/update")
    public String updateStudent(@ModelAttribute("student") StudentModel studentModel) {
        studentService.updateStudent(studentModel);
        return "redirect:/main/students/update/success";
    }
    
    // 変更完了画面
 	@GetMapping("/main/students/update/success")
 	public String updateSuccess(Model model, @AuthenticationPrincipal TeacherModel teacher) {
 		String teacherName = teacher.getTeacherName();
		model.addAttribute("teacherName", teacherName);
 	    return "score/student/student_update_success";
 	}
}
