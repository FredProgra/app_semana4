package edu.pe.cibertec.app_semana4.Controller;

import edu.pe.cibertec.app_semana4.Model.PromedioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormImcController {
    @GetMapping("/promedionotas")
    public String index(Model model){

        return "formimc";
    }
}
