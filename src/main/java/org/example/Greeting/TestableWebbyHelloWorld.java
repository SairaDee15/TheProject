package org.example.Greeting;
import io.javalin.Javalin;

public class TestableWebbyHelloWorld {
    private final Javalin server;

    public TestableWebbyHelloWorld() {
        this.server = Javalin.create();
        this.server.get("hello", context -> context.result("Hello, world!"));
    }

    public Javalin start() {
        return this.server.start(7000);
    }

    public Javalin stop() {
        return this.server.stop();
    }

    public static void main(String[] args) {
        TestableWebbyHelloWorld api = new TestableWebbyHelloWorld();
        api.start();
    }
}