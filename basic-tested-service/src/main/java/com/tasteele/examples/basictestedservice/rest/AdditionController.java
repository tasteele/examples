package com.tasteele.examples.basictestedservice.rest;

import com.tasteele.examples.basictestedservice.core.AdditionService;
import com.tasteele.examples.basictestedservice.core.domain.AddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdditionController {
    @Autowired private AdditionService additionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(@RequestBody AddRequest addRequest) {
        return additionService.add(addRequest.getNumbers());
    }

    @RequestMapping(value = "/absolute/{number}", method = RequestMethod.GET)
    public Integer absoluteValue(@PathVariable Integer number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }
}
