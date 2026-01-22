package viikkoharjoitus.vko1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MyController {

    @RequestMapping("/index")
    public String indexMessage() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    public String contactMessage() {
        return "This is the contact page";
    }

    @RequestMapping("/hello")
    public String welcomeMessage(@RequestParam (name="name", required = false, defaultValue = "anonymous") String name, 
                                    @RequestParam (name="location", required = false, defaultValue = "unknown") String location) {
        return "Welcome to the " + location + " " + name + "!";
    }


}
