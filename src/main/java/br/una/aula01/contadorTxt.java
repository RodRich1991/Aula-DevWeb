package br.una.aula01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class contadorTxt {

    public int lerContador(){

        String caminho = "contador.txt", linha = "";
        int contador;

        try{
            FileReader arq = new FileReader(caminho);

            BufferedReader lerArq = new BufferedReader(arq);

            linha = lerArq.readLine(); // lê a primeira linha
            arq.close();
        }catch(IOException e){
            salvarContador(0);
        }

        if(linha=="" || linha==null)contador = 0;
        else contador = Integer.parseInt(linha);

        return contador;
    }

    public void salvarContador(int cont){

        File arq = new File("contador.txt");

        try{
            FileWriter fw2 = new FileWriter(arq, true);
            fw2.close();

            FileWriter fw = new FileWriter(arq);
            BufferedWriter br = new BufferedWriter(fw);

            br.write(cont+"");

            br.close();
            fw.close();
        }
        catch(IOException e){

        }

    }

    @GetMapping("/contadortxt")
    @ResponseBody
    public String criaTelatxt(){

        return criaString();
    }

    public String criaString(){

        return "<h1>Contador</h1>" +
                "<input type=number value="+lerContador()+" readonly>"+
                "<br><a href='/conttxt-M'><button>   -   </button></a>"+
                "<a href='/conttxt-P'><button>   +   </button></a>";
    }

    @GetMapping("/conttxt-P")
    @ResponseBody
    public String contamais(){
        int con = lerContador();
        con++;
        salvarContador(con);
        return criaTelatxt();
    }
    @GetMapping("/conttxt-M")
    @ResponseBody
    public String contamenos(){
        int con = lerContador();
        con--;
        salvarContador(con);
        return criaTelatxt();
    }
}
