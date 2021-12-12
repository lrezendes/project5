package comp152.project5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PhoneNumberApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(PhoneNumberApplication.class.getResource("PhoneNumber-View.fxml"));
        Scene scene=null;
        try{
            scene=new Scene(fxmlLoader.load(),500,500);
        }
        catch (IOException e){
            System.out.println("Error loading phone number fxml file");
        }
        stage.setTitle("Phone Number Window  Sam");
        stage.setScene(scene);
        stage.show();
    }
}
