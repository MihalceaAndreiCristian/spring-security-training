package ro.amihalcea.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.amihalcea.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    public List<StudentModel> studentModelList = new ArrayList<>(List.of(
            new StudentModel(1,"Andrei", "Java"),
            new StudentModel(2,"Alex", "DotNet")
    ));

    @GetMapping("students")
    public List<StudentModel> getStudentList(){
        return studentModelList;
    }

//    @GetMapping("csrf-token")
//    public CsrfToken getCSRFToken(HttpServletRequest request){
//        return (CsrfToken) request.getAttribute("_csrf");
//    }

    @PostMapping("students")
    public void addStudent(@RequestBody StudentModel student){
        studentModelList.add(student);
    }
}
