package gal.usc.etse.soap;

import gal.usc.etse.soap.analyzer.Analyzer;
import gal.usc.etse.soap.calculator.Calculator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        try{
            //Server1
            URL wsdlURL = new URL("http://localhost:8080/calculator?wsdl");
            QName SERVICE_NAME = new QName("http://calculator.soap.etse.usc.gal/", "Calculator");
            Service service = Service.create(wsdlURL, SERVICE_NAME);
            Calculator client = service.getPort(Calculator.class);

            //Server2
            URL wsd2lURL = new URL("http://localhost:8090/analyzer?wsdl");
            QName SERVICE_NAME2 = new QName("http://analyzer.soap.etse.usc.gal/", "Analyzer");
            Service service2 = Service.create(wsd2lURL, SERVICE_NAME2);
            Analyzer client_2 = service2.getPort(Analyzer.class);

            int selec = 0, result=0, a=0, b=0;
            int[] lista;
            double resultD = 0;
            String resultString = "", texto = "", palabraA = "", palabraB = "";
            int[] array={};

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            String menu = "\n\n------------Opciones------------\n"+
                    "\t-Matematicas:\n"
                        +"\t\t1) Sumar 2 enteros\n"
                        +"\t\t2) Restar 2 enteros\n"
                        +"\t\t3) Multiplicar 2 enteros\n"
                        +"\t\t4) Dividir divisor entre dividendo\n"
                        +"\t\t5) Potencia base a exponente\n"
                        +"\t\t6) Raiz cuadrada de entero\n"
                        +"\t\t7) Logaritmo de entero\n"
                        +"\t\t8) Maximo de una lista de enteros\n"
                        +"\t\t9) Minimo de una lista de enteros\n"
                        +"\t\t10) Media de una lista de enteros\n"
                        +"\t\t11) Mediana de una lista de enteros\n"
                        +"\t\t12) Desviacion de una lista de enteros\n"
                    +"\t-Texto:\n"
                        +"\t\t13) Imprimir textos\n"
                        +"\t\t14) Contar palabras de un texto\n"
                        +"\t\t15) Contar caracteres de un texto\n"
                        +"\t\t16) Contar frases de un texto\n"
                        +"\t\t17) Contar veces que aparece una palabra en un texto\n"
                        +"\t\t18) Detectar palabra mas usada\n"
                        +"\t\t19) Detectar palabra menos usada\n"
                        +"\t\t20) Substituir una palabra objetivo por otra reemplazo en un texto\n"
                    +"\t-Salir: -1\n"
            +"-------------------------------------------\n";

            while(selec > -1){
                System.out.println(menu);
                System.out.println("Opcion: ");
                selec = Integer.parseInt(reader.readLine());
                switch (selec){
                    //Suma
                    case 1:{
                        System.out.println("Introduce los dos sumandos");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        System.out.println("b:");
                        b = Integer.parseInt(reader.readLine());
                        result = client.sum(a, b);
                        System.out.println("Suma "+a+"+"+b+"="+result);
                        break;
                    }
                    //Resta
                    case 2:{
                        System.out.println("Introduce los dos enteros a restar");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        System.out.println("b:");
                        b = Integer.parseInt(reader.readLine());
                        result = client.sub(a, b);
                        System.out.println("Resta "+a+"-"+b+"="+result);
                        break;
                    }
                    //Multiplicacion
                    case 3:{
                        System.out.println("Introduce los dos multiplos");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        System.out.println("b:");
                        b = Integer.parseInt(reader.readLine());
                        result = client.mult(a, b);
                        System.out.println("Resta "+a+"*"+b+"="+result);
                        break;
                    }
                    //Division
                    case 4:{
                        System.out.println("Introduce dividendo y divisor");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        System.out.println("b:");
                        b = Integer.parseInt(reader.readLine());
                        resultD = client.div(a, b);
                        System.out.println("Resta "+a+"/"+b+"="+resultD);
                        break;
                    }
                    //Potencia
                    case 5:{
                        System.out.println("Introduce los dos enteros a restar");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        System.out.println("b:");
                        b = Integer.parseInt(reader.readLine());
                        result = client.pow(a, b);
                        System.out.println("Potencia "+a+"^"+b+"="+result);
                        break;
                    }
                    //Raiz cuadrada
                    case 6:{
                        System.out.println("Introduce el entero al que aplicar la raiz");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        resultD = client.sqrt(a);
                        System.out.println("Raiz de "+a+"="+resultD);
                        break;
                    }
                    //logaritmo
                    case 7:{
                        System.out.println("Introduce el entero al que aplicar el logartimo");
                        System.out.println("a:");
                        a = Integer.parseInt(reader.readLine());
                        resultD = client.log(a);
                        System.out.println("Ln de "+a+"="+resultD);
                        break;
                    }
                    //maximo
                    case 8:{
                        System.out.println("Calcular maximo:");
                        System.out.println("Introduce el numero de enteros");
                        System.out.println("Numero:");
                        a = Integer.parseInt(reader.readLine());
                        lista = new int[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Introduce el entero");
                            b = Integer.parseInt(reader.readLine());
                            lista[i] = b;
                        }
                        result = client.max(lista);
                        System.out.println("Maximo: "+result);
                        break;
                    }
                    //Minimo
                    case 9:{
                        System.out.println("Calcular minimo:");
                        System.out.println("Introduce el numero de enteros");
                        System.out.println("Numero:");
                        a = Integer.parseInt(reader.readLine());
                        lista = new int[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Introduce el entero");
                            b = Integer.parseInt(reader.readLine());
                            lista[i] = b;
                        }
                        result = client.min(lista);
                        System.out.println("Minimo: "+result);
                        break;
                    }
                    //Media
                    case 10:{
                        System.out.println("Calcular media:");
                        System.out.println("Introduce el numero de enteros");
                        System.out.println("Numero:");
                        a = Integer.parseInt(reader.readLine());
                        lista = new int[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Introduce el entero");
                            b = Integer.parseInt(reader.readLine());
                            lista[i] = b;
                        }
                        resultD = client.average(lista);
                        System.out.println("Media: "+resultD);
                        break;
                    }
                    //Mediana
                    case 11:{
                        System.out.println("Calcular mediana:");
                        System.out.println("Introduce el numero de enteros");
                        System.out.println("Numero:");
                        a = Integer.parseInt(reader.readLine());
                        lista = new int[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Introduce el entero");
                            b = Integer.parseInt(reader.readLine());
                            lista[i] = b;
                        }
                        resultD = client.median(lista);
                        System.out.println("Mediana: "+resultD);
                        break;
                    }
                    //Desviacion
                    case 12:{
                        System.out.println("Calcular desviacion:");
                        System.out.println("Introduce el numero de enteros");
                        System.out.println("Numero:");
                        a = Integer.parseInt(reader.readLine());
                        lista = new int[a];
                        for (int i = 0; i < a; i++) {
                            System.out.println("Introduce el entero");
                            b = Integer.parseInt(reader.readLine());
                            lista[i] = b;
                        }
                        resultD = client.dev(lista);
                        System.out.println("Desviacion: "+resultD);
                        break;
                    }
                    //Imprimir texto
                    case 13:{
                        System.out.println("Introduce el texto a imprimir");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        resultString = client_2.texto(texto);
                        System.out.println(resultString);
                        break;
                    }
                    //Contar palabras
                    case 14:{
                        System.out.println("Introduce el texto al que contarle las palabras");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        result = client_2.words(texto);
                        System.out.println("Numero de palabras: "+result);
                        break;
                    }
                    //Contar caracteres
                    case 15:{
                        System.out.println("Introduce el texto al que contarle los caracteres");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        result = client_2.charac(texto);
                        System.out.println("Numero de caracteres: "+result);
                        break;
                    }
                    //Contar frases
                    case 16:{
                        System.out.println("Introduce el texto al que contarle las frases");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        result = client_2.sentences(texto);
                        System.out.println("numero de frases: "+result);
                        break;
                    }
                    //Contar una palabra
                    case 17:{
                        System.out.println("Introduce el texto en el que contar las aparaciciones de la palabra");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        System.out.println("Palabra a contar:");
                        palabraA = reader.readLine();
                        result = client_2.wordCount(texto, palabraA);
                        System.out.println("Numero de apariciones de "+palabraA+": "+result);
                        break;
                    }
                    //Mas comun
                    case 18:{
                        System.out.println("Introduce el texto al que buscar la palabra mas comun");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        resultString = client_2.mostWord(texto);
                        System.out.println("Palabra mas comun: "+resultString);
                        break;
                    }
                    //Menos comun
                    case 19:{
                        System.out.println("Introduce el texto al que buscar la palabra menos comun");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        resultString = client_2.lessWord(texto);
                        System.out.println("Palabra menos comun: "+resultString);
                        break;
                    }
                    //Cambiar palabra
                    case 20:{
                        System.out.println("Introduce el texto donde reemplazar la palabra objetivo por el reemplazo");
                        System.out.println("Texto:");
                        texto = reader.readLine();
                        System.out.println("Palabra objetivo:");
                        palabraA = reader.readLine();
                        System.out.println("Palabra reemplazo:");
                        palabraB = reader.readLine();
                        resultString = client_2.swapWord(texto, palabraA, palabraB);
                        System.out.println("Resultado:\n\t"+resultString);
                        break;
                    }
                    //Cambiar palabra
                    case -1:{
                        System.out.println("Saliendo del programa");
                        break;
                    }
                    default:{
                        selec=0;
                        System.out.println("Opcion no soportada, escoge un numero del 1 al 20.");
                        break;
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
