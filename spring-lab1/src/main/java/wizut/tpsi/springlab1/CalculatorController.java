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
    public String hello(Model model, CalculatorForm c) {

       float wynik=0;

        String wyn;
        switch (c.getOperation()) {
            case "+": {
                wynik = c.getX()+c.getY();

                break;
            }
            case "-": {
                wynik = c.getX()-c.getY();
                break;
            }
            case "*": {
                wynik = c.getX()*c.getY();
                break;
            }
            case "/": {

                if(c.getY()==0)
                {
                    wyn="Nie dziel przez zero cholero!";
                    model.addAttribute("wyniczek", wyn);
                    return "home";
                }
                wynik = c.getX()/c.getY();
                break;
            }
        }

        wyn= c.getX()+c.getOperation()+c.getY()+"="+wynik;


        model.addAttribute("wyniczek", wyn);
        return "home";
    }
}
