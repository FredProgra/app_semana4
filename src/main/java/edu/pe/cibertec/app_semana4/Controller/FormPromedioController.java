package edu.pe.cibertec.app_semana4.Controller;

import edu.pe.cibertec.app_semana4.Model.ImcModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormPromedioController {

    @GetMapping("/calcularimc")
    public String index(Model model){
        model.addAttribute("imcmodel",new ImcModel());
        model.addAttribute("verresultado",false);
        model.addAttribute("notificacion",false);

        return "formpromedio";
    }
    @PostMapping("/index")
    public  String calcularimc(Model model, @ModelAttribute("imcmodel") ImcModel imc){
        Double tallametros= imc.getTalla()/100;
        Double valorimc= imc.getPeso()/(tallametros*tallametros);
        String condicion="";
        String coloralert="alert-danger";

        if (valorimc<=18.5){
            condicion="debajo del peso";
            coloralert="alert-dark";
        } else if (valorimc<=25) {
            condicion="Con peso noraml";
            coloralert="alert-primary";

        } else if (valorimc<=30) {
            condicion="Con sobreso";
            coloralert="alert-warning";

        } else if (valorimc<=35) {
            condicion="Con obesidad leve";


        } else if (valorimc<=39) {
            condicion="obesidad media";
            coloralert="alert-blue";

        }else {condicion="muerte";
        coloralert="alert-danger";}
model.addAttribute("verresultado",true);
        model.addAttribute("resultado","Su valor de IMC;"+String.format("%.2f",valorimc)+",usted se encuentra :"+condicion);
        model.addAttribute("coloralert",coloralert);

        return "formpromedio";

    }
}
