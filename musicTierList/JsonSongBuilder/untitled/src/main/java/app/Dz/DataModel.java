package app.Dz;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty rank = new SimpleStringProperty();
    private final StringProperty imgLink = new SimpleStringProperty();

    public  StringProperty titleProperty(){
        return title;
    }
    public  StringProperty rankProperty(){
        return rank;
    }
    public   StringProperty imgLinkProperty(){
        return imgLink;
    }
}
