package visa.w2;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class NumbersController {

    @Autowired
    private NumbersService numbersSvc;

    @GetMapping("/generateForm")
    public String generateForm(Model model) {
        // create instance for numbers object
        Numbers numbers = new Numbers();
        // provide object name to thymeleaf html >>> th:object="${numbers}"
        model.addAttribute("numbers", numbers);

        return "generateForm";
    }

    @PostMapping("/generateForm")
    public String generateNumbers(@ModelAttribute Numbers submitNumber, Model model) {
        // calling method from @Service
        Set<Integer> result = numbersSvc.generateRandomNumbers(submitNumber);
        // provide data to thymeleaf html
        model.addAttribute("setNumbers", result);
                
        return "generateResult";
    }


    

}
