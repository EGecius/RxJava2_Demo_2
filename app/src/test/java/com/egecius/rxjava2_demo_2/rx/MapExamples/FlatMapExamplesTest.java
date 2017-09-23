package com.egecius.rxjava2_demo_2.rx.MapExamples;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.TestObserver;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class FlatMapExamplesTest {

	private FlatMapExamples mSut;

	private List<String> list0to2 = new ArrayList<String>() {{
		add("zero");
		add("one");
		add("two");
	}};


	@Before
	public void setup() {
		mSut = new FlatMapExamples();
	}

	@Test
	public void flatmaps() {
		TestObserver<String> testObserver = mSut.flatmap(list0to2).test();

		testObserver.assertNoErrors();
		testObserver.assertComplete();
		List<String> values = testObserver.values();
		assertThat(values.size()).isEqualTo(3);
		assertThat(values.get(0)).isEqualTo("zero");
		assertThat(values.get(1)).isEqualTo("one");
		assertThat(values.get(2)).isEqualTo("two");
	}

	@Test
	public void fromIterable() {
		TestObserver<String> testObserver = mSut.fromIterable(list0to2).test();

		testObserver.assertNoErrors();
		testObserver.assertComplete();
		List<String> values = testObserver.values();
		assertThat(values.size()).isEqualTo(3);
		assertThat(values.get(0)).isEqualTo("zero");
		assertThat(values.get(1)).isEqualTo("one");
		assertThat(values.get(2)).isEqualTo("two");
	}

	@Test
	public void flatmaps_onSingle() {
		TestObserver<String> testObserver = mSut.flatmapOnSingle(69).test();

		testObserver.assertNoErrors();
		testObserver.assertComplete();
		List<String> values = testObserver.values();
		assertThat(values.size()).isEqualTo(1);
		assertThat(values.get(0)).isEqualTo("69");
	}

	@Test
	public void flatMapOneToOne() {
		TestObserver<String> testObserver = mSut.flatMapOneToOne(69).test();

		testObserver.assertNoErrors();
		testObserver.assertComplete();
		testObserver.assertValues("69");
	}

}