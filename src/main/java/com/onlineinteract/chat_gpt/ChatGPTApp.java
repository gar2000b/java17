package com.onlineinteract.chat_gpt;

import okhttp3.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

public class ChatGPTApp {
    public static void main(String[] args) throws IOException {
        // Your OpenAI API Key
        String apiKey = "";  // Replace with your API key

        // Create an HTTP client
        OkHttpClient client = new OkHttpClient();

        // Set up the request body for GPT-4
        JsonObject messageObject = new JsonObject();
        messageObject.addProperty("role", "user");
        messageObject.addProperty("content", "What is the capital of France?");

        JsonArray messagesArray = new JsonArray();
        messagesArray.add(messageObject);

        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("model", "gpt-4o");
        requestBody.add("messages", messagesArray);

        // Prepare the request with headers
        RequestBody body = RequestBody.create(
                requestBody.toString(),
                MediaType.get("application/json; charset=utf-8")
        );
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        // Send the request and get the response
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("Request failed: " + response.message());
                System.out.println("Response Code: " + response.code());
                if (response.body() != null) {
                    System.out.println("Response Body: " + response.body().string());
                }
            }
        }
    }
}
