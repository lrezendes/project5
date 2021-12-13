package comp152.project5;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneNumberDataHandler {
    private HttpClient dataGrabber;
    private String webLocation;
    private String codePhone;
    private String prefixPhone;
    private String codeNames;
    private String countryNames;

    public PhoneNumberDataHandler(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
        this.codePhone=codePhone;
        this.prefixPhone=prefixPhone;
        this.codeNames=codeNames;
        this.countryNames=countryNames;
    }

    public HashMap<String,String> getPhoneDataNames(){
        var httpBuilder= HttpRequest.newBuilder();  //creates new Httprequest builder
        var dataRequest=httpBuilder.uri(URI.create(webLocation)).build();  //crates new httprequest
        HttpResponse<String> response=null;              //creates a string of Httpresponce          //var isnt used bcuz you cannot assign a null value to var
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString()); //treats the bit of data returned as string
        }
        catch (IOException exception) {
            System.out.println("Error in network");  //error with connection
        }
        catch (InterruptedException e) {
            System.out.println("Error in data transfer");  //error with data transfer
        }
        if (response==null){
            System.out.println("HttpResponse response is null, exiting");
            System.exit(-1);
        }
        var responseBody=response.body();  //creates string variable of the responce body
        var gsonInterpreter=new Gson();  //introduces new gson variable

        HashMap<String,String> phoneDataNames=gsonInterpreter.fromJson(responseBody, HashMap.class);  //creates a hashmap from the gson interpreter introduced above
        return phoneDataNames;

//        var codeSet=phoneDataNames.keySet();
//        ArrayList<String> listOfKeys=new ArrayList<String>(codeSet);
//
//        var countrySet=phoneDataNames.values();
//        ArrayList<String> listOfValues=new ArrayList<String>(countrySet);

//
//
//
//        for (var code:codeSet){
//            PhoneNumberDataHandler namesObject = new PhoneNumberDataHandler(String, codeNames);
//        }



    }
    public HashMap<String, String> getPhoneDataPhone(){  //same as above but for the other api
        var httpBuilder=HttpRequest.newBuilder();
        var dataRequest=httpBuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String>response=null;
        try {
            response=dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString()); //treats the bit of data returned as string
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
        var responceBody=response.body();
        var gsonInterpreter=new Gson();
        HashMap<String,String> phoneDataPhone=gsonInterpreter.fromJson(responceBody, HashMap.class);
        return phoneDataPhone;

    }

}

