package backend.viikkoharjoitus2.tehtava2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import backend.viikkoharjoitus2.tehtava2.domain.Student;

@Controller
public class Tehtava2Controller {

    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Pekka", "Suomalainen"));
        students.add(new Student("Matti", "Kuusi"));
        students.add(new Student("Ville", "Mänty"));
    }

    @GetMapping("/hello")
    public String helloForm(Model model) {
        model.addAttribute("students", students);
        return "hello";
    }

}
