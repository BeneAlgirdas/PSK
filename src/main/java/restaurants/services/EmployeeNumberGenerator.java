package restaurants.services;

import restaurants.common.GenerateEmployeeNumber;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
public class EmployeeNumberGenerator implements Serializable{

//    Baeldung CompletableFuture:
    public Future<Integer> generateEmployeeNumber() throws InterruptedException {
        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(10000);
            completableFuture.complete(new Random().nextInt(100));
            return null;
        });

        return completableFuture;
    }
}
