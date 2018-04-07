package br.una.aula01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrimeiroController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(){
        return  "<title>Desenvolvimento Web</title>"+
                "<font color='blue'>Hello World</font>" +
                "<br><a href=/rodrigo>Pagina do Rodrigo</a>";
    }

    @GetMapping("/rodrigo")
    @ResponseBody
    public String nome(){
    return "Rodrigo";
    }

    @GetMapping("/formulario")
    @ResponseBody
    public String formulario(){
        return "<form action='/saida-form'>" +
                "   <label>N1: </label><br>"+
                "   <input type='number' name='n1'/><br>"+
                "   <label>N2: </label><br>"+
                "   <input type='number' name='n2'/><br>"+
                "   <button type='submit' value='enviar'>Enviar</button>"+
                "</form>";
    }

    @GetMapping("/saida-form")
    @ResponseBody
    public String saidaForm(int n1, int n2){

        float div = n1/n2;

        return "<h1>Resultado</h1>"+
                "<h3>Soma:</h3> "+n1+" + "+n2+" = "+(n1+n2)+
                "<h3>Subtração:</h3> "+n1+" - "+n2+" = "+(n1-n2)+
                "<h3>Multiplicação:</h3> "+n1+" x "+n2+" = "+(n1*n2)+
                "<h3>Divisão:</h3> "+n1+" / "+n2+" = "+div;
    }

    @GetMapping("/contador")
    @ResponseBody
    public String contador(){

        int cont =0;

        return "<h1>Contador</h1>" +
                "<input type=number value="+cont+" readonly>"+
                "<br><a href='/subtrair?cont="+cont+"'><button>   -   </button></a>"+
                "<a href='/somar?cont="+cont+"'><button>   +   </button></a>";
    }

    @GetMapping("/somar")
    @ResponseBody
    public String somar(int cont){

        cont++;

        return "<h1>Contador</h1>" +
                "<input type=number value="+cont+" readonly>"+
                "<br><a href='/subtrair?cont="+cont+"'><button>   -   </button></a>"+
                "<a href='/somar?cont="+cont+"'><button>   +   </button></a>";
    }

    @GetMapping("/subtrair")
    @ResponseBody
    public String subtrair(int cont){

        cont--;

        return "<h1>Contador</h1>" +
                "<input type=number value="+cont+" readonly>"+
                "<br><a href='/subtrair?cont="+cont+"'><button>   -   </button></a>"+
                "<a href='/somar?cont="+cont+"'><button>   +   </button></a>";
    }


}
