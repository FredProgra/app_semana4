package edu.pe.cibertec.app_semana4.Controller;

import edu.pe.cibertec.app_semana4.Model.ImcModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormPromedioController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("frm",)
        return "formpromedio";
    }
}
