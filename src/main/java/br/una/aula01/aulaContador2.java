package br.una.aula01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 101162011 on 05/04/2018.
 */
@Controller
public class aulaContador2 {

    int cont =0;

    @GetMapping("/contador2")
    @ResponseBody
    public String contador2(){

        return criaTela();
    }

    public String criaTela(){

        return "<h1>Contador</h1>" +
                "<input type=number value="+cont+" readonly>"+
                "<br><a href='/cont-sub'><button>   -   </button></a>"+
                "<a href='/cont-som'><button>   +   </button></a>";
    }

    @GetMapping("/cont-som")
    @ResponseBody
    public String contamais(){
        cont++;
        return contador2();
   }
    @GetMapping("/cont-sub")
    @ResponseBody
    public String contamenos(){
        cont--;
        return contador2();
    }
}
