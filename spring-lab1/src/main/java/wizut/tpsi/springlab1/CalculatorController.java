package wizut.tpsi.springlab1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class CalculatorController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("/count")
    public String hello(Model model, Float x, Float y, String operation) {

       float wynik=0;

        String wyn;
        switch (operation) {
            case "+": {
                wynik = x+y;

                break;
            }
            case "-": {
                wynik = x-y;
                break;
            }
            case "*": {
                wynik = x*y;
                break;
            }
            case "/": {

                if(y==0)
                {
                    wyn="Nie dziel przez zero cholero!";
                    model.addAttribute("wyniczek", wyn);
                    return "home";
                }
                wynik = x/y;
                break;
            }
        }

        wyn= x+operation+y+"="+wynik;


        model.addAttribute("wyniczek", wyn);
        return "home";
    }
}
