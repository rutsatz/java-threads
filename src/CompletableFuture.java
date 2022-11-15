import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuture {

    public static void log(String msg) {
        System.out.println(String.format("%s %s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")), java.lang.Thread.currentThread().getName(), msg));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log("enviando a tarefa");
         java.util.concurrent.CompletableFuture.supplyAsync (() -> {
            log("oi da thread 1");
            try {java.lang.Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            log("oi da thread 2");
            return true;
        }).thenAccept(result -> {
             log("consumindo resultado 1");
             try {java.lang.Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
             log("consumindo resultado 2");
        });
        log("tarefa enviada");
        java.lang.Thread.sleep(500);
        log("terminando main");
        java.lang.Thread.sleep(1500);


    }

}
