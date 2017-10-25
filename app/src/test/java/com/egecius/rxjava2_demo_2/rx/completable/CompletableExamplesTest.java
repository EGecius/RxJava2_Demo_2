package com.egecius.rxjava2_demo_2.rx.completable;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.observers.TestObserver;

@RunWith(MockitoJUnitRunner.class)
public class CompletableExamplesTest {

    private CompletableExamples mSut;

    @Before
    public void setUp() {
        mSut = new CompletableExamples();
    }

    @Test
    public void andThen() {
        TestObserver<Void> testObserver = mSut.andThen().test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.THIRD_COMPLETABLE);
    }

    @Test
    public void doOnCompleteAndThen() {
        TestObserver<Void> testObserver = mSut.doOnCompleteAndThen().test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.THIRD_COMPLETABLE);
        assertThat(list.get(3)).isEqualTo(CompletableExamples.DO_ON_COMPLETE);
    }

    @Test
    public void divergingPaths_A() {
        TestObserver<Void> testObserver = mSut.divergingPaths(CompletableExamples.Path.A).test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.PATH_A_COMPLETABLE);
    }

    @Test
    public void divergingPaths_B() {
        TestObserver<Void> testObserver = mSut.divergingPaths(CompletableExamples.Path.B).test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.PATH_B_COMPLETABLE);
    }

    @Test
    public void divergingPathWithMaybeA() {
        TestObserver<Void> testObserver = mSut.divergingPathWithMaybeA().test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.PATH_A_COMPLETABLE);
    }

    @Test
    public void divergingPathWithMaybeB() {
        TestObserver<Void> testObserver = mSut.divergingPathWithMaybeB().test();

        testObserver
                .assertComplete()
                .assertNoErrors();
        List<String> list = mSut.list;
        assertThat(list.size()).isEqualTo(3);
        assertThat(list.get(0)).isEqualTo(CompletableExamples.FIRST_COMPLETABLE);
        assertThat(list.get(1)).isEqualTo(CompletableExamples.SECOND_COMPLETABLE);
        assertThat(list.get(2)).isEqualTo(CompletableExamples.PATH_B_COMPLETABLE);
    }

}