package com.example.paulbrown.basilio.logistic;

import com.example.paulbrown.basilio.modules.Modules;

/**
 * Created by Paul Brown on 16.06.2017.
 */
public class Logistic {

    private static boolean isModuleFreedman = true;

    public static Integer progressState(String text){
        Integer percent = 50;
        if (isModuleFreedman){
            percent = (int) Modules.toCountFreedman(text);
        }
        return percent;
    }

    public static void setModuleChecked(String name, Boolean checked){
        if (name.equals("freedman")){
            isModuleFreedman = checked;
        }
    }
}
