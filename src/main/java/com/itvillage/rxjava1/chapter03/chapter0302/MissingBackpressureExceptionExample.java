package com.itvillage.rxjava1.chapter03.chapter0302;

import com.itvillage.utils.LogType;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MissingBackpressureExceptionExample {
    public static void main(String[] agrs) throws InterruptedException {
        Flowable.interval(1L, TimeUnit.MILLISECONDS)    // 통지
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .observeOn(Schedulers.computation()) // 데이터를 처리하는 스레드를 분리하여 독립적으로 처리
                .subscribe(
                        data -> {
                            Logger.log(LogType.PRINT, "# 소비자 처리 대기 중..");
                            TimeUtil.sleep(1000L);
                            Logger.log(LogType.ON_NEXT, data);
                        },
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        Thread.sleep(2000L);

    }
}
