package gal.usc.etse.soap.analyzer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface Analyzer {
    @WebMethod(operationName = "Devolver_texto")
    @WebResult(name = "resultado")
    String texto(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Contar_palabras")
    @WebResult(name = "resultado")
    int words(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Contar_caracteres")
    @WebResult(name = "resultado")
    int charac(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Contar_frases")
    @WebResult(name = "resultado")
    int sentences(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Contar_usos")
    @WebResult(name = "resultado")
    int wordCount(@WebParam(name = "texto") String text, @WebParam(name = "palabra") String palabra);

    @WebMethod(operationName = "Mas_usada")
    @WebResult(name = "resultado")
    String mostWord(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Menos_usada")
    @WebResult(name = "resultado")
    String lessWord(@WebParam(name = "texto") String text);

    @WebMethod(operationName = "Reemplazar")
    @WebResult(name = "resultado")
    String swapWord(@WebParam(name = "texto") String text, @WebParam(name = "objetivo") String objetivo, @WebParam(name = "reemplazo") String reemplazo);
}
