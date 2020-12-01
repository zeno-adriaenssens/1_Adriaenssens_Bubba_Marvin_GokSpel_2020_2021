package model.database;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import model.Speler;

import java.io.IOException;
import java.util.ArrayList;

public abstract class XlsLoadSaveTemplate {
    //word niet gebruikt, waarom mag k ni gewoon 1 interface gebruiken?
    public abstract void saveSpelers(ArrayList<Speler> spelers) throws WriteException, IOException, BiffException;
    public abstract ArrayList<Speler> loadSpelers();
}
