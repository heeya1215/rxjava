package com.itvillage.chapter05.chapter0503;

import com.itvillage.utils.Logger;
import io.reactivex.Observable;

/**
 * FlatMap 두번째 유형을 이용항 구구단의 2단 출력 예제
 */
public class ObservableFlatMapExample03 {
    public static void main(String[] args) {
        Observable.range(2, 1)
                .flatMap(
                        data -> Observable.range(1, 9),
                        (sourceData, transformedData) -> sourceData + " * " + transformedData + " = " + sourceData * transformedData
                )
                .subscribe(Logger::on);

    }
}