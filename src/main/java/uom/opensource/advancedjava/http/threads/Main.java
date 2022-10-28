package uom.opensource.advancedjava.http.threads;

import uom.opensource.advancedjava.http.Post;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        String todoURL = "https://jsonplaceholder.typicode.com/todos";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(todoURL))
                .header("accept", "application/json").build();

        CompletableFuture<HttpResponse<String>> responseCompletableFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("BEFORE JOIN");
        String body = responseCompletableFuture.join().body();
        System.out.println("AFTER JOIN");
        System.out.println(body);
    }
}
