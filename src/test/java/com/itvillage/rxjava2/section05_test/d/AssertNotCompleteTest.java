package com.itvillage.rxjava2.section05_test.d;

import com.itvillage.rxjava2.section04_test.SampleObservable;
import com.itvillage.utils.TimeUtil;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * assertNotComplete를 이용하여 A 지점과 B 지점의 매출 합계 처리가 지정된 시간안에 끝나지않는지 검증하는 예제
 */
public class AssertNotCompleteTest {
    @Test
    public void assertNotCompleteTest() {
        SampleObservable.getSalesOfBranchA()
                .zipWith(
                        SampleObservable.getSalesOfBranchB(),
                        (a, b) -> {
                            TimeUtil.sleep(1000L);
                            return a + b;
                        }
                )
                .test()
                .awaitDone(3000L, TimeUnit.MILLISECONDS)
                .assertNotComplete();
    }

}
