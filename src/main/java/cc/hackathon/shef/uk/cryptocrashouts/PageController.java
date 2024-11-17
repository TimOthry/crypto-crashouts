package cc.hackathon.shef.uk.cryptocrashouts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/card")
    public String viewCard() {
        return "viewCards";
    }
}
