package com.aluracursos.calculos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.aluracursos.modelos.Moneda;

public class Conversor {
    public Moneda calculoMoneda(String monedaBase, String monedaAConvertir){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f1346872ef441c1e5438fc4d/pair/" + monedaBase + "/" + monedaAConvertir);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda.");
        }
    }
}
