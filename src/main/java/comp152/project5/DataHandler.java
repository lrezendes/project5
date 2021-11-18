package comp152.project5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

public class DataHandler {
    private HttpClient dataGrabber;
    private String webLocation;

    public DataHandler(String webLocation){
        dataGrabber = HttpClient.newHttpClient();
        this.webLocation = webLocation;
    }

    public UniversityDataType[] getData(){
        var httpbuilder = HttpRequest.newBuilder();
        var dataRequest = httpbuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response = null;
        try{
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exception){
            System.out.println("Error with the network");
        }
        catch (InterruptedException e){
            System.out.println("Error completing data transfer");
        }
        if(response == null){
            System.out.println("Something went very wrong, quitting program");
            System.exit(-1);
        }
        var responseBody = response.body();
        var jsonInterpreter = new Gson();
        var makeupData= jsonInterpreter.fromJson(responseBody, MakeupDataType[].class);
        return makeupData;
    }

    class MakeupDataType{
        String alpha_two_code;
        ArrayList<String> web_pages;
        String product_type;
        String product_category;
        String ("Canadian", "CertClean", "Chemical Free", "Dairy Free",
                        "EWG Verified", "EcoCert", "Fair Trade", "Gluten Free",
                        "Hypoallergenic", "Natural", "No Talc", "Non-GMO", "Organic",
                        "Peanut Free Product", "Sugar Free", "USDA Organic", "Vegan",
                        "alcohol free", "cruelty free", "oil free", "purpicks",
                        "silicone free", "water free") product_tags;
        String brand;

        ArrayList<String> domains;

        @Override
        public String toString(){
            return name;
        }
}
