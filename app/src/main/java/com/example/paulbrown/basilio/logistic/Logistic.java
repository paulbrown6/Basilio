package com.example.paulbrown.basilio.logistic;

import com.example.paulbrown.basilio.modules.Modules;

/**
 * Created by Paul Brown on 16.06.2017.
 * Edtited and released by Cyril Bulbum on 22.06.2017
 */
public class Logistic {

    private static boolean isFreedmanModuleUsed = true;
    private static boolean isBigrModuleUsed = true;
    private static boolean isDictModuleUsed = true;

    public static Integer toCountProgressState(String text){
        Integer percent=0;

        if (!isFreedmanModuleUsed && !isBigrModuleUsed && !isDictModuleUsed)
            return 0;
        int res = (isFreedmanModuleUsed ? Modules.toCountFreedmanRus(text): 0) + (isBigrModuleUsed ? Modules.toCountExplicitBigrammes(text) : 0) + (isDictModuleUsed ? -Modules.toCountDictionary(text): 0);
         return ( res < 0 ? 0: res);
    }

    public static void setModuleChecked(String name, Boolean checked){
       switch (name){
           case ("1"):{  //used such short name for memory economy and more quick access to data
               isFreedmanModuleUsed = checked;
           }
           case ("2"):{
               isBigrModuleUsed = checked;
           }
           case ("3"):{
               isDictModuleUsed = checked;
           }
       }
    }
}
