package cc.hackathon.shef.uk.cryptocrashouts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";  // This refers to a view named 'index.html' or similar
    }
}
