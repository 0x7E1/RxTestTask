package com.onseo.testtask;

import com.google.common.base.Stopwatch;
import com.onseo.testtask.domain.dto.ResultObject;
import com.onseo.testtask.facade.ApplicationRunnerFacade;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Application {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("-------------------------------------------------------------------------");
        Stopwatch syncStopwatch = Stopwatch.createStarted();
        ApplicationRunnerFacade facade = new ApplicationRunnerFacade();
        ResultObject resultObjectFromSync = facade.getResult();
        syncStopwatch.stop();
        log.info("SYNC: Time elapsed: " + syncStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("-------------------------------------------------------------------------");
        Stopwatch asyncStopwatch = Stopwatch.createStarted();
        CompletableFuture<ResultObject> resultObjectFuture = facade.getResultAsync();
        ResultObject resultObjectFromAsync = resultObjectFuture.get();
        asyncStopwatch.stop();
        log.info("ASYNC: Time elapsed: " + asyncStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("-------------------------------------------------------------------------");
        Stopwatch observableStopwatch = Stopwatch.createStarted();
        Observable<ResultObject> resultObjectObservable = facade.getResultObservable();
        ResultObject resultObjectFromObservable = resultObjectObservable.blockingFirst();
        observableStopwatch.stop();
        log.info("OBSERVABLE: Time elapsed: " + observableStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("-------------------------------------------------------------------------");

        System.out.println();
        log.info("SYNC time: " + syncStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("ASYNC time: " + asyncStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("OBSERVABLE time: " + observableStopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}