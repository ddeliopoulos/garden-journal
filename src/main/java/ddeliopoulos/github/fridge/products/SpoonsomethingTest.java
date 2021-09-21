package ddeliopoulos.github.fridge.products;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpoonsomethingTest {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                                         .uri(URI.create("https://api.spoonacular.com/recipes/findByIngredients?apiKey=2811fa55cd974f5fb297f725ae495097&ingredients=rice&number=5"))
                                         .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join();
    }
}
