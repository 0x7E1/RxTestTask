package com.onseo.TestTask;

import com.onseo.TestTask.domain.dto.ResultObject;
import com.onseo.TestTask.facade.ApplicationRunnerFacade;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class Application {
    
    public static void main(String[] args) {
        Stopwatch stopwatch = Stopwatch.createStarted();

        ResultObject resultObject = new ApplicationRunnerFacade().getResult();

        stopwatch.stop();
        System.out.println("Time elapsed: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }
}