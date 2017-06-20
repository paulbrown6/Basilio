package com.example.paulbrown.basilio.logistic;

import com.example.paulbrown.basilio.modules.Modules;

/**
 * Created by Paul Brown on 16.06.2017.
 */
public class Logistic {

    private static boolean isFreedmanModuleUsed = true;
    private static boolean isBigrModuleUsed = true;
    private static boolean isDictModuleUsed = true;

    public static Integer toCountProgressState(String text){
        Integer percent=0;

        if (!(isFreedmanModuleUsed && isBigrModuleUsed && isDictModuleUsed))
            return (int) (100*Math.random());

        if (isFreedmanModuleUsed && isBigrModuleUsed && isDictModuleUsed)
            return (int) (0.3*Modules.toCountFreedman(text)+0.3*Modules.toCountDictionary(text)+0.001*Modules.toCountExplicitBigrammes(text));

        return 0;
    }

    public static void setModuleChecked(String name, Boolean checked){
        if (name.equals("freedman")){
            isFreedmanModuleUsed = checked;
        }
    }
}
