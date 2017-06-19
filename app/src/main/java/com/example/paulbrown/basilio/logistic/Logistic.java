package com.example.paulbrown.basilio.logistic;

import com.example.paulbrown.basilio.modules.Modules;

/**
 * Created by Paul Brown on 16.06.2017.
 */
public class Logistic {

    private static Modules module = new Modules();
    private static boolean isModuleFreedman = true;
    private static boolean isModuleBigrammes = true;

    public static Integer progressState(String text){
        Integer percent = 50;
        Integer intfreedman = 1;
        Integer intbigrammes = 1;
        if (isModuleFreedman){
            intfreedman = (int) module.toCountFreedman(text);
        }
//        if (isModuleBigrammes){
//            intbigrammes = module.toCountExplicitBigrammes(text);
//        }
        percent = (intfreedman*100);
        return percent;
    }

    public static void setModuleChecked(String name, Boolean checked){
        if (name.equals("freedman")){
            isModuleFreedman = checked;
        }
        else if (name.equals("bigrammes")){
            isModuleBigrammes = checked;
        }
    }
}
