package gal.usc.etse.soap;

import gal.usc.etse.soap.analyzer.Analyzer;
import gal.usc.etse.soap.analyzer.AnalyzerImpl;
import javax.xml.ws.Endpoint;

public class Server2 {
    public static void main(String[] args) {
        Analyzer c = new AnalyzerImpl();
        String address = "http://localhost:8090/analyzer";
        Endpoint.publish(address, c);
    }
}
