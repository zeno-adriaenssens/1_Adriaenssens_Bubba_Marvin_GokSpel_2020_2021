package model.database;

public enum LoadSaveEnum {
    TEKST ("model.Strategies.SpelerTekstLoadSave"),
    XLS ("model.Strategies.SpelerXlsLoadSave");

    private final String klasseNaam;

    LoadSaveEnum(String klasseNaam) {
        this.klasseNaam = klasseNaam;
    }
    public String getKlasseNaam() { return klasseNaam; }
}
