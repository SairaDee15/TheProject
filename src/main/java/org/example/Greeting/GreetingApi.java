package org.example.Greeting;

import io.javalin.Javalin;

public class GreetingApi {

    private final Javalin server;

    public GreetingApi() {
        this.server = Javalin.create();
        this.server.post("/greet", context -> {
            String name = context.body();
            context.result("Hello, " + name + "!");
            context.status(201);
        });
    }

    public Javalin start() {
        return this.server.start(7000);
    }

    public Javalin stop() {
        return this.server.stop();
    }

    public static void main(String[] args) {
        GreetingApi api = new GreetingApi();
        api.start();
    }
}
