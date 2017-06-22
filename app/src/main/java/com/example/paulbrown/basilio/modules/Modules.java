package com.example.paulbrown.basilio.modules;

import java.util.HashMap;
import java.util.Map;

public class Modules {
    private static StringBuilder bigrammes;
    private static StringBuilder dictionary;

    public static int toCountExplicitBigrammes (String text){
        if (text.length() < 3) return 0;

        StringBuilder BigramzAll = new StringBuilder(bigrammes.toString());
        String oneBigramme;
        int k=0;
        int nSymb;

        do
        {

            nSymb = BigramzAll.indexOf(" ");
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
    public static int toCountFreedmanRus(String text){
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

        return (int) Math.abs(Ic-0.0553);
    }
    public static int toCountDictionary(String text){

        if (text.length() < 3) return 0;

        StringBuilder tempDictionary = new StringBuilder(dictionary.toString());
        String word;
        int k=0;
        int nSymb;

        while (tempDictionary.length()>0)
        {
            k=0;
            nSymb = tempDictionary.indexOf(" ");
            word = tempDictionary.substring(0,nSymb);
            tempDictionary.delete(0, nSymb+1);//оторвали слово до \n

            if (word.equals("end"))
                break;

            if (nSymb == 2 || nSymb == 1) continue;




            for (int i = 0; i < (text.length()-word.length()); i++)
            {
                if (text.substring(i, i + word.length()).equals(word) && k == 0)
                    k++;
            }
        }

        return k;
}

    public static void toSetModules(String bigr, String dict){
        bigrammes = new StringBuilder(bigr+" ");
        dictionary = new StringBuilder(dict+" ");
    }
}
