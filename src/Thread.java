import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Thread {

    public static void log(String msg) {
        System.out.println(String.format("%s %s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")), java.lang.Thread.currentThread().getName(), msg));
    }

    public static void main(String[] args) throws InterruptedException {
        log("oi da main");
        new java.lang.Thread(() -> {
            log("oi da thread");
            try {
                java.lang.Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            log("oi da thread");
        }).start();
        java.lang.Thread.sleep(1000);
        log("oi da main");

    }

}
