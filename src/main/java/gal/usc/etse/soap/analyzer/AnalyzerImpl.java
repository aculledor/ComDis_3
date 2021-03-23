package gal.usc.etse.soap.analyzer;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(
        endpointInterface = "gal.usc.etse.soap.analyzer.Analyzer",
        serviceName = "Calculator"
)
public class AnalyzerImpl implements Analyzer {
    @Override
    public int words(String texto) {
        if(texto == null || texto.isEmpty())
            return 0;
        String[] palabras = texto.split("\\s+");
        return palabras.length;
    }

    @Override
    public int charac(String texto) {
        if(texto == null || texto.isEmpty())
            return 0;
        return texto.length();
    }

    @Override
    public int sentences(String texto) {
        if(texto == null || texto.isEmpty())
            return 0;
        String[] palabras = texto.split("\\s.");
        return palabras.length;
    }

    @Override
    public int wordCount(String texto, String palabra) {
        if(texto == null || texto.isEmpty())
            return 0;
        String[] palabras = texto.split("\\s+");
        int count = 0;
        for (String s : palabras) {
            if (s.contains(palabra))
                count++;
        }
        return count;
    }

    private Map<String, Integer> wordAppearance(String texto) {
        if(texto == null || texto.isEmpty())
            return null;
        String[] palabras = texto.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        for (String str : palabras) {
            if (map.keySet().contains(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }

        return map;
    }

    @Override
    public String mostWord(String texto) {
        if(texto == null || texto.isEmpty())
            return "";
        int maxValue = 0, val;
        String mostCommon = "", key;

        Map<String, Integer> map = this.wordAppearance(texto);

        for ( Map.Entry<String,Integer> entry : map.entrySet()){
            key  = entry.getKey();
            val = entry.getValue();
            if (val > maxValue){
                maxValue = val;
                mostCommon = key;
            }
            // Si hay empate se reemplaza
            else if (val == maxValue && mostCommon.compareTo(key) > 0)
                mostCommon = key;
        }
        return mostCommon;
    }

    @Override
    public String lessWord(String texto) {
        if(texto == null || texto.isEmpty())
            return "";
        int maxValue = 0, val;
        String mostCommon = "", key;

        Map<String, Integer> map = this.wordAppearance(texto);

        for ( Map.Entry<String,Integer> entry : map.entrySet()){
            key  = entry.getKey();
            val = entry.getValue();
            if (val > maxValue){
                maxValue = val;
                mostCommon = key;
            }
            // Si hay empate se reemplaza
            else if (val == maxValue && mostCommon.compareTo(key) > 0)
                mostCommon = key;
        }
        return mostCommon;
    }

    @Override
    public String swapWord(String texto, String objetivo, String reemplazo) {
        if(texto == null || texto.isEmpty())
            return "";
        texto.replaceAll(objetivo, reemplazo);
        return texto;
    }



}
