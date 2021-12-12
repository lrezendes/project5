package comp152.project5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstWindowApplication extends Application {
    @Override
    public void start(Stage stage)throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(FirstWindowApplication.class.getResource("FirstWindow-view.fxml"));
        Scene scene=null;
        try{
            scene=new Scene(fxmlLoader.load(),500,500);
        }
        catch (IOException e){
            System.out.println("FXML file not found");
        }
        stage.setTitle("Project 5  Sam, Lauren and Maria");
        stage.setScene(scene);
        stage.show();
    }

@FXML
public void handleOpenMakeupWindow(ActionEvent event){
        var makeupLoc = new FXMLLoader(MakeupApplication.class.getResource("Makeup-view.fxml"));
        Scene makeupScene = null;
        try {
            makeupScene = new Scene(makeupLoc.load(), 900, 600);
        } catch (IOException e) {
            System.out.println("Couldn't load makeup window");
            e.printStackTrace();
        }
        Stage makeupWindow = new Stage();
        makeupWindow.setScene(makeupScene);
        makeupWindow.setTitle("See - here is the makeup window");
        makeupWindow.show();
        }
        @FXML
        public void handleClose(ActionEvent event) {System.exit(0);}
}

