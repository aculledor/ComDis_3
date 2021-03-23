package gal.usc.etse.soap;

import gal.usc.etse.soap.analyzer.Analyzer;
import gal.usc.etse.soap.calculator.Calculator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        //Server1
        URL wsdlURL = new URL("http://localhost:8080/calculator?wsdl");
        QName SERVICE_NAME = new QName("http://calculator.soap.etse.usc.gal/", "Calculator");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        Calculator client = service.getPort(Calculator.class);

        //Server2
        wsdlURL = new URL("http://localhost:8081/Analyzer?wsdl");
        SERVICE_NAME = new QName("http://analyzer.soap.etse.usc.gal/", "Analyzer");
        service = Service.create(wsdlURL, SERVICE_NAME);
        Analyzer client_2 = service.getPort(Analyzer.class);

        int array[] = { 12, 2, 9, 4, 5 };

        String stringPrueba = "Una frase es una unidad compuesta potencialmente de dos o más palabras, pero que no tiene las características proposicionales de la oración. Las frases, típicamente, aunque no siempre, funcionan como constituyentes de las oraciones, Varios aspectos de esta definición deben comentarse. En primer lugar, la frase no se ha definido como compuesta siempre de dos a más palabras, sino como potencialmente compuesta de dos o más palabras. Por lo tanto, una frase puede ser literalmente una secuencia de palabras o puede ser una sola palabra a la cual se pueden agregar eventualmente modificadores para formar una secuencia de palabras.";

        int result = client.sum(1, 2);
        System.out.println("Suma: "+result);

        result = client.sub(1, 2);
        System.out.println("Resta: "+result);

        result = client.mult(1, 2);
        System.out.println("Mult: "+result);

        double resultD = client.div(1, 2);
        System.out.println("Div: "+resultD);

        result = client.pow(4, 2);
        System.out.println("Pow: "+result);

        resultD = client.sqrt(3);
        System.out.println("Sqrt: "+resultD);

        resultD = client.log(3);
        System.out.println("Log: "+resultD);

        result = client.max(array);
        System.out.println("Max: "+result);

        result = client.min(array);
        System.out.println("Min: "+result);

        resultD = client.average(array);
        System.out.println("Average: "+resultD);

        resultD = client.median(array);
        System.out.println("Median: "+resultD);

        resultD = client.dev(array);
        System.out.println("Desviation: "+resultD);
    }
}
