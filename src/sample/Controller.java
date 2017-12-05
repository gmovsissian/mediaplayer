package sample;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.awt.*;
import java.io.File;

public class Controller {

    @FXML
    MediaView mv;
    @FXML
    Media me;
    @FXML
    MediaPlayer mp;


    public void initialize(){
        String path=new File("src/media/video.mp4").getAbsolutePath();
            me=new Media(new File(path).toURI().toString());
            mp=new MediaPlayer(me);
            mv.setMediaPlayer(mp);
//            mp.setAutoPlay(false);


    }
    public void play(){
        mp.play();
    }


    }



