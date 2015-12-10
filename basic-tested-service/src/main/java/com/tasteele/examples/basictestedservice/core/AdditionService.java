package com.tasteele.examples.basictestedservice.core;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdditionService {

    public Integer add(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}
