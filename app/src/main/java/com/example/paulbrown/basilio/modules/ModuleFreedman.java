package com.example.paulbrown.basilio.modules;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Paul Brown on 14.06.2017.
 */
public class ModuleFreedman {

    public static double getCountFreedman(String text){
        return toCountFreedman(text);
    }

    private static double toCountFreedman(String text){
        int m = text.length();
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
        Double length = new Double(Double.valueOf(text.length()));
        Double Ic = new Double(0.0);
        Double pi = new Double(0.0);
        int i = 0;
        for (Map.Entry entry : Frequency.entrySet()) {
            pi = Double.valueOf(entry.getValue().toString()) / length;
            Ic = Ic + Math.pow(pi, 2);
        }
        return Ic;
    }
}
