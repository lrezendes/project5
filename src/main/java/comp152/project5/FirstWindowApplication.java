package comp152.project5;

import javafx.application.Application;
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
        stage.setTitle("Project 5 :)  Sam, Lauren and Maria");
        stage.setScene(scene);
        stage.show();
    }
}
