package model.database;

import model.Strategies.LoadSaveStrategies;

public class LoadSaveFactory {
    public static LoadSaveStrategies createStrategy(String taalCode){
        LoadSaveEnum taalEnum = LoadSaveEnum.valueOf(taalCode);
        String klasseNaam = taalEnum.getKlasseNaam();
        LoadSaveStrategies strategy = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.newInstance();
            strategy = (LoadSaveStrategies) dbObject;
        }
        catch (Exception e){}
        return strategy;
    }
}
