package com.devops.app;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {

    public static String getMessage() {
        return "DevOps CI/CD Pipeline is working!";
    }

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080),
            0
        );

        server.createContext("/", exchange -> {

            String response = """
                    <html>
                    <head>
                        <title>DevOps CI/CD Pipeline</title>
                    </head>
                    <body>
                        <h1>DevOps CI/CD Pipeline is working!</h1>
                        <p>Application deployed successfully using Docker.</p>
                    </body>
                    </html>
                    """;

            byte[] responseBytes =
                response.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html; charset=UTF-8");

            exchange.sendResponseHeaders(
                200,
                responseBytes.length
            );

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(responseBytes);
            }
        });

        server.start();

        System.out.println(
            "DevOps application running on port 8080"
        );
    }
}
