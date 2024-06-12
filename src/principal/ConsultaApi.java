package principal;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import model.Monedas;

public class ConsultaApi {

    public Monedas SearchCoins(String monedaBaseTxt, String monedaCambioTxt){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/c737c2c299a23e7d27b95a04/pair/"+monedaBaseTxt+"/"+monedaCambioTxt);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(url)
                                         .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }
        catch(Exception e){
            throw new RuntimeException("No se ha encontrado la moneda");
        }
    }

}
