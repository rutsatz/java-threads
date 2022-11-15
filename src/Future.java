import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future {

    private static final ExecutorService threadpool =
            Executors.newFixedThreadPool(3);

    public static void log(String msg) {
        System.out.println(String.format("%s %s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")), java.lang.Thread.currentThread().getName(), msg));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        log("enviando a tarefa");
        java.util.concurrent.Future<Boolean> result = threadpool.submit(() -> {
            log("oi da thread");
            try {java.lang.Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
            log("oi da thread");
            return true;
        });
        log("tarefa enviada");
        result.get(); // blocks calling thread
//        java.lang.Thread.sleep(500);
        log("terminando main");
    }

}
