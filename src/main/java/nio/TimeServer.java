package main.java.nio;

import java.util.concurrent.Executors;

public class TimeServer {

    public static void main(String[] args) {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8080);
        Executors.newSingleThreadExecutor().execute(timeServer);
    }

}
