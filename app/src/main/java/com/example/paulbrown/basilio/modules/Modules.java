package com.example.paulbrown.basilio.modules;

import java.util.HashMap;
import java.util.Map;

public class Modules {
    private StringBuilder bigrammes = new StringBuilder();

    /*
    private void toInputBigrammes() throws FileNotFoundException, InterruptedException {
        int k=0;

        FileInputStream input = new FileInputStream("E:\\Programs\\IntelliJ IDEA Community Edition 2016.3\\Programmes\\SD31GeneticAlgorithmSimpleCipherBreak\\src\\com\\company\\exbigrammes.txt");
        Scanner sc = new Scanner(input);

        StringBuilder bigrammes = new StringBuilder("");
        while (sc.hasNext()){
            bigrammes.append(sc.next());
            bigrammes.append('\n');
        }
        this.bigrammes = bigrammes;
    }

    private void toInputDictionary() throws FileNotFoundException {
        int k=0;

        FileInputStream input = new FileInputStream("E:\\Programs\\IntelliJ IDEA Community Edition 2016.3\\Programmes\\SD31GeneticAlgorithmSimpleCipherBreak\\src\\com\\company\\dictionary360KB.txt");
        Scanner sc = new Scanner(input);

        StringBuilder dictionary = new StringBuilder("");
        while (sc.hasNext()){
            dictionary.append(sc.next());
            dictionary.append('\n');
        }
        this.dictionary = dictionary;
    }
    */

    public int toCountExplicitBigrammes (String text){
        /*
        * Возвращает количество появлений запретных биграмм
        * */
        StringBuilder BigramzAll = new StringBuilder(this.bigrammes.toString());
        String oneBigramme;
        int k=0;
        int nSymb;

        do
        {

            nSymb = BigramzAll.indexOf("\n");
            oneBigramme = BigramzAll.substring(0,nSymb);
            BigramzAll.delete(0, nSymb+1);   //оторвали слово до \n



            for (int i = 0; i < (text.length()-oneBigramme.length()); i++)
            {
                if (text.substring(i, i + oneBigramme.length()).equals(oneBigramme))
                    k++;
            }
        } while (BigramzAll.length()>0);

        return k;
    }
    public static double toCountFreedman(String text){
        int m = text.length();

        if (m == 0) return 0;

        Map<Character, Integer> Frequency = new HashMap<Character, Integer>();
        text = text.toUpperCase();
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Frequency.put(text.charAt(i), 0);
            }
        }
        for (int i = 0; i < text.length(); i++) {
            if ((int) text.charAt(i) != 10 && (int) text.charAt(i) != 13) {
                Integer value = Frequency.get(text.charAt(i));
                value = value + 1;
                Frequency.put(text.charAt(i), value);
            }
        }
        Double length = (double) text.length(); //It is simplified, so it may not work. Check it.
        Double Ic = 0.0;
        Double pi = 0.0;
        int i = 0;
        for (Map.Entry entry : Frequency.entrySet()) {
            pi = Double.valueOf(entry.getValue().toString()) / length;
            Ic = Ic + Math.pow(pi, 2);
        }
        return Ic;
    }

}
