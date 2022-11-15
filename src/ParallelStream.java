import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void log(String msg) {
        System.out.println(String.format("%s %s - %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS")), java.lang.Thread.currentThread().getName(), msg));
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> list = IntStream.range(1, 100)
                .boxed()
                .collect(Collectors.toList());

//        list.parallelStream().forEach(integer -> {
//            log("## num " + integer);
//        });

        ForkJoinPool fjp = new ForkJoinPool(3);
        Runnable callable = () -> {
            list.parallelStream().forEach(integer -> {
                log("@@ num " + integer);
            });
        };

        Executors.newWorkStealingPool().submit(callable).get();

//        try {
//            fjp.submit(callable).get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        fjp.execute(callable);

        java.lang.Thread.sleep(1000);
    }

}
