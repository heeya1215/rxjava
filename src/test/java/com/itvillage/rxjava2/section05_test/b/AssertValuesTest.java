package com.itvillage.rxjava2.section05_test.b;

import com.itvillage.common.CarMaker;
import com.itvillage.rxjava2.section04_test.SampleObservable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertValues를 이용하여 조건에 맞는 1개 이상의 데이터의 값과 순서과 일치하는지 검증하는 예제
 */
public class AssertValuesTest {
    @Test
    public void getCarMakerAssertValueTest(){
        SampleObservable.getDuplicatedCarMakerStream()
                .filter(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .test()
                .awaitDone(1L, TimeUnit.MILLISECONDS)
                .assertValues(CarMaker.CHEVROLET, CarMaker.CHEVROLET);
    }
}
