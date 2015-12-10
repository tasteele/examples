package com.tasteele.examples.basictestedservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasteele.examples.basictestedservice.core.AdditionService;
import com.tasteele.examples.basictestedservice.core.domain.AddRequest;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdditionControllerTest extends MockMvcTestBase {

    @Autowired @InjectMocks private AdditionController subject;
    @Mock private AdditionService additionService;

    @Test
    public void add_shouldCallService() throws Exception {
        AddRequest addRequest = new AddRequest();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        addRequest.setNumbers(numbers);
        String contentsAsJson = new ObjectMapper().writeValueAsString(addRequest);
        stub(additionService.add(any(List.class))).toReturn(4);
        mockMvc.perform(post("/add")
                .content(contentsAsJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$").value(4));
        Class<List<Integer>>clazz = (Class<List<Integer>>) numbers.getClass();
        ArgumentCaptor<List<Integer>> captor = ArgumentCaptor.forClass(clazz);
        verify(additionService).add(captor.capture());
        List <Integer>passedNumbers = captor.getValue();
        assertThat(passedNumbers, equalTo(numbers));

    }


}