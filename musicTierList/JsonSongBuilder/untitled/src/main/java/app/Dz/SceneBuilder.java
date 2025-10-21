package app.Dz;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class SceneBuilder implements Builder<Region> {
    private DataModel dataModel;
    public Region build() {
        dataModel = new DataModel();
        BorderPane results = new BorderPane();
        results.getStyleClass().add("results");
        results.setCenter(new VBox(createTitleBox(),createRankingBox(),createLinkBox()));
        results.setBottom(createSubmitButton());
        BorderPane.setAlignment(results, Pos.CENTER);
        return results;
    }

    private Node songTitleInput(){
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(dataModel.titleProperty());
        textField.getStyleClass().add("standard");
        return textField;
    }
    private Node songRankingInput(){
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(dataModel.rankProperty());
        textField.getStyleClass().add("standard");
        return textField;
    }
    private Node songLinkInput(){
        TextField textField = new TextField();
        textField.textProperty().bindBidirectional(dataModel.imgLinkProperty());
        textField.getStyleClass().add("standard");
        return textField;
    }

    private Node createTitleBox(){
        HBox hbox = new HBox(new Label("Title"), songTitleInput());
        hbox.getStyleClass().add("standardFull");
        return hbox;
    }
    private Node createRankingBox(){
        HBox hbox = new HBox(new Label("Rank"), songRankingInput());
        hbox.getStyleClass().add("standardFull");
        return hbox;
    }
    private Node createLinkBox(){
        HBox hbox = new HBox(new Label("Link"), songLinkInput());
        hbox.getStyleClass().add("standardFull");
        return hbox;
    }
    private Node createSubmitButton(){
        Button button = new Button("Submit");
        button.setOnAction(event -> {JSONEdit.addSong("../../songs.json",dataModel.titleProperty().get(),dataModel.rankProperty().get(),dataModel.imgLinkProperty().get());});

        return button;
    }
}
