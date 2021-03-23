package gal.usc.etse.soap;

import gal.usc.etse.soap.calculator.Calculator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8081/calculator?wsdl");
        QName SERVICE_NAME = new QName("http://calculator.soap.etse.usc.gal/", "Calculator");
        Service service = Service.create(wsdlURL, SERVICE_NAME);
        Calculator client = service.getPort(Calculator.class);

        int array[] = { 12, 2, 9, 4, 5 };

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
