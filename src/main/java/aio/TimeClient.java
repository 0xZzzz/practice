package aio;

import java.util.concurrent.Executors;

public class TimeClient {

    public static void main(String[] args) {
        Executors.newSingleThreadExecutor().execute(new AsyncTimeClientHandler("127.0.0.1", 8080));
    }

}
