package com.xiangxue.jack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/async")
public class AsyncController {

    @RequestMapping("/callableTest")
    public @ResponseBody
    Callable<String> callableTest() {
        return () -> {
            TimeUnit.SECONDS.sleep(1);
            return "Ok";
        };
    }

    @RequestMapping("/webAsyncTaskTest")
    public @ResponseBody WebAsyncTask<String> webAsyncTaskTest() {
        WebAsyncTask webAsyncTask = new WebAsyncTask<String>(3 * 1000L, () -> {
            TimeUnit.SECONDS.sleep(4);
            return "Ok";
        });

        webAsyncTask.onTimeout(() -> {
            System.out.println("========超时了====");
            return "timeout";
        });

        webAsyncTask.onCompletion(() -> {
            System.out.println("========完成了====");
        });

        return webAsyncTask;
    }
}
