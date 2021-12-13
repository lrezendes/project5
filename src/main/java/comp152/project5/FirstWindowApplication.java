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
        FXMLLoader fxmlLoader=new FXMLLoader(FirstWindowApplication.class.getResource("FirstWindow-view.fxml")); //loads the fxml file into a window
        Scene scene=null;
        try{
            scene=new Scene(fxmlLoader.load(),500,500);  //creates a scene variable, with set width and height
        }
        catch (IOException e){
            System.out.println("FXML file not found");  //exception for if the fxml file isnt found
        }
        stage.setTitle("Project 5  Sam, Lauren and Maria");  //sets the title of the stage
        stage.setScene(scene);                             // sets the scene from previously declared scene variable
        stage.show();                                       //shows the stage
    }
}

