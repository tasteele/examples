package com.tasteele.examples.basictestedservice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class AdditionService {

    public Integer add(List numbers) {
        return null;
    }
}
