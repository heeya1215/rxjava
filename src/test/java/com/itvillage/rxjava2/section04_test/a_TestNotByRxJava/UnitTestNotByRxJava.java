package com.itvillage.rxjava2.section04_test.a_TestNotByRxJava;

import com.itvillage.common.CarMaker;
import com.itvillage.rxjava2.section04_test.SampleObservable;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * RxJava의 API를 사용하지 않은 Unit Test 예제
 */
public class UnitTestNotByRxJava {
    @Test
    public void getCarMakerStreamSyncTest(){
        List<CarMaker> carMakerList = new ArrayList<>();
        SampleObservable.getCarMakerStream()
                .subscribe(data -> carMakerList.add(data));
        assertThat(carMakerList.size(), is(5));
    }
}
