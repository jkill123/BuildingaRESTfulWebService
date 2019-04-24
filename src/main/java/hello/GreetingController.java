package hello;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    @GetMapping("/")
    public String main(Map<String, Object> model){
       return "Get mapping ";
    }

//    @RequestMapping(value = "/main", method = RequestMethod.GET)
//    public String goHome(){
//        return "static/index.html";
//    }
    @Controller
    public class OneController{
        @RequestMapping("/main")
    public String one(){
            return "redirect:/static/index.html";
        }
    }

}
