package main.java.nio;

import java.util.concurrent.Executors;

public class TimeClient {

    public static void main(String[] args) {
        TimeClientHandle timeClient = new TimeClientHandle("127.0.0.1", 8080);
        Executors.newSingleThreadExecutor().execute(timeClient);
    }

}
