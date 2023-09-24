package edu.pe.cibertec.app_semana4.Controller;

import edu.pe.cibertec.app_semana4.Model.PrimoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormPrimoController {
    @GetMapping("/frmprimo")
    public String index(Model model){
        model.addAttribute("primomodel",new PrimoModel());
        model.addAttribute("verresultado",false);

        return "frmprimo";
    }
    @PostMapping("/frmprimo")

    public  String index(@ModelAttribute("primomodel") PrimoModel primo,Model model){

        String res=esPrimo(primo.getNumero())?"El numero es primo"+ primo.getNumero():"El numero no es primo"+primo.getNumero();
        model.addAttribute("verresultado",true);
        model.addAttribute("resultado",res);

        return "frmprimo";
    }
    private  boolean esPrimo(Integer numro){
        Integer contador=0;
        for (int i=1;i<=numro;i++){
            if (numro%i==0){
                contador++;
            }
        }

        return contador<=2;
    }
}
