package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;


import java.io.File;

public class Controller {

    @FXML
    MediaView mv;
    @FXML
    Media me;
    @FXML
    MediaPlayer mp;
    @FXML
    Slider volume;
//    @FXML
//    Button open2;

    private String filepath;
    @FXML
    public void open2(){

        FileChooser fileChooser=new FileChooser();
        FileChooser.ExtensionFilter filter=new FileChooser.ExtensionFilter("Select a file","*.mp4");
        fileChooser.getExtensionFilters().add(filter);
        File file=fileChooser.showOpenDialog(null);
        filepath=file.toURI().toString();
        if (filepath!=null){
            me = new Media(filepath);
            mp = new MediaPlayer(me);
            mv.setMediaPlayer(mp);
            mp.play();
            volume.setValue(mp.getVolume()*100);
            volume.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mp.setVolume(volume.getValue()/100);
                }
            });
            volume.setStyle("-fx-control-inner-background: red;");
        }
    }




    public void initialize() {

    }







    public void play() {
        mp.play();
        mp.setRate(1);

    }
    public void pause(){
        mp.pause();
    }
    public void stop(){
        mp.stop();
    }
    public void fast(){
        mp.setRate(2);
    }
    public void slow(){
        mp.setRate(.2);
    }


}



