package paczuski.web.function.dynamic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicController {

    private String pole1;
    private Integer pole2;



    @RequestMapping("/")
    String testFunction(){
        return "WORK";
    }
}
