package demo;

import okhttp3.*;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.service.RepositoryService;

import java.io.IOException;

public class Hello {

    private static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {

        Request request = new Request.Builder()
                .url("https://api.github.com/repos/freewind-demos/java-github-change-topics-demo/topics")
                .header("Authorization", "token " + Helper.readGithubToken())
                .header("Accept", "application/vnd.github.mercy-preview+json")
                .put(RequestBody.create(MediaType.get("application/json"), "{\n" +
                        "  \"names\": [\n" +
                        "    \"java\",\n" +
                        "    \"github\",\n" +
                        "    \"api\",\n" +
                        "    \"topic-now-" + System.currentTimeMillis() + "\"\n" +
                        "  ]\n" +
                        "}"))
                .build();

        Response response = client.newCall(request).execute();
        String body = response.body().string();
        System.out.println(body);

    }

}

