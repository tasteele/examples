package com.tasteele.examples.basictestedservice.rest;

import com.tasteele.examples.basictestedservice.core.AdditionService;
import com.tasteele.examples.basictestedservice.core.domain.AddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {
    @Autowired private AdditionService additionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(@RequestBody AddRequest addRequest) {
        return additionService.add(addRequest.getNumbers());
    }
}
