package uom.opensource.advancedjava.http;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {

        String todoURL = "https://jsonplaceholder.typicode.com/todos";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(todoURL))
                .header("accept", "application/json").build();

        Post[] posts;

        try {

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            Gson gson = new Gson();
            posts = gson.fromJson(response.body(), Post[].class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Post post : posts)
            System.out.println(post);
    }
}
