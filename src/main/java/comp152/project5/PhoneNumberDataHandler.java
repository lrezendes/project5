package comp152.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PhoneNumberDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;

    public PhoneNumberDataHandler(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
    }

    public PhoneNumberDataTypes[] getPhoneData(){
        var httpBuilder= HttpRequest.newBuilder();
        var dataRequest=httpBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response=null;                                             //var isnt used bcuz you cannot assign a null value to var
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exception) {
            System.out.println("Error in network");
        }
        catch (InterruptedException e) {
            System.out.println("Error in data transfer");
        }
        if (response==null){
            System.out.println("HttpResponse response is null, exiting");
            System.exit(-1);
        }
        var responseBody=response.body();
        var gsonInterpreter=new Gson();
        var phoneData=gsonInterpreter.fromJson(responseBody, PhoneNumberDataTypes[].class);
        return phoneData;
    }


    class PhoneNumberDataTypes{
        String countryName;
        String countryAbbreviation;
    }
}

