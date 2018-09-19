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
        Stopwatch stopwatch = Stopwatch.createStarted();
        ApplicationRunnerFacade facade = new ApplicationRunnerFacade();
        ResultObject resultObjectFromSync = facade.getResult();
        stopwatch.stop();
        log.info("SYNC: Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("-------------------------------------------------------------------------");
        stopwatch = Stopwatch.createStarted();
        CompletableFuture<ResultObject> resultObjectFuture = facade.getResultAsync();
        ResultObject resultObjectFromAsync = resultObjectFuture.get();
        stopwatch.stop();
        log.info("ASYNC: Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        log.info("-------------------------------------------------------------------------");
        stopwatch = Stopwatch.createStarted();
        Observable<ResultObject> resultObjectObservable = facade.getResultObservable();
        ResultObject resultObjectFromObservable = resultObjectObservable.blockingFirst();
        stopwatch.stop();
        log.info("OBSERVABLE: Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");

        //TODO not important but we can compare resultObjectFromSync, resultObjectFromAsync, resultObjectFromObservable
    }
}