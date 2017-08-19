package aio;

import java.util.concurrent.Executors;

public class TimeServer {

    public static void main(String[] args) {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(8080);
        Executors.newSingleThreadExecutor().execute(timeServer);
    }

}
