package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * switchMap 대신 concatMap을 쓸 경우 비효율적인 검색 예제
 */
public class ObservableSwitchMapExample03 {
    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        // 사용자가 입력하는 검색어라고 가정한다.
        final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");

        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .concatMap(data -> {
                    String keyword = keywords.get(data.intValue());

                    return Observable.just(searcher.search(keyword))
                            .doOnNext(notUse -> System.out.println("================================================================="))
                            .delay(300L, TimeUnit.MILLISECONDS);
                })
                .flatMap(resultList -> Observable.fromIterable(resultList))
                .subscribe(Logger::on);

        TimeUtil.sleep(2000L);
    }
}