package com.tasteele.examples.basictestedservice.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AdditionServiceTest {
    private AdditionService subject;

    @Before
    public void setUp() {
        subject = new AdditionService();
    }

    @Test
    public void add_shouldAdd() throws Exception {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        assertThat(subject.add(numbers), is(12));
    }

}