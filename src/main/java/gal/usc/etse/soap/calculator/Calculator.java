package gal.usc.etse.soap.calculator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.OptionalInt;

@WebService
public interface Calculator {
    @WebMethod(operationName = "suma")
    @WebResult(name = "resultado")
    int sum(@WebParam(name = "sumando1") int a, @WebParam(name = "sumando2") int b);

    @WebMethod(operationName = "resta")
    @WebResult(name = "resultado")
    int sub(@WebParam(name = "sumando1") int a, @WebParam(name = "sumando2") int b);

    @WebMethod(operationName = "multiplicacion")
    @WebResult(name = "resultado")
    int mult(@WebParam(name = "multiplo1") int a, @WebParam(name = "multiplo2") int b);

    @WebMethod(operationName = "division")
    @WebResult(name = "resultado")
    double div(@WebParam(name = "dividendo") int a, @WebParam(name = "divisor") int b);

    @WebMethod(operationName = "potencia")
    @WebResult(name = "resultado")
    int pow(@WebParam(name = "base") int a, @WebParam(name = "exponente") int b);

    @WebMethod(operationName = "raiz")
    @WebResult(name = "resultado")
    double sqrt(@WebParam(name = "base") int a);

    @WebMethod(operationName = "logaritmo")
    @WebResult(name = "resultado")
    double log(@WebParam(name = "base") int a);

    @WebMethod(operationName = "maximo")
    @WebResult(name = "resultado")
    int max(int[] nums);

    @WebMethod(operationName = "minimo")
    @WebResult(name = "resultado")
    int min(int[] nums);

    @WebMethod(operationName = "media")
    @WebResult(name = "resultado")
    double average(int[] nums);

    @WebMethod(operationName = "mediana")
    @WebResult(name = "resultado")
    double median(int[] nums);

    @WebMethod(operationName = "desviacion")
    @WebResult(name = "resultado")
    double dev(int[] nums);
}
