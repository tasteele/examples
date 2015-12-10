package com.tasteele.examples.basictestedservice.rest;

import com.tasteele.examples.basictestedservice.SpringTestBase;
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
abstract public class MockMvcTestBase extends SpringTestBase {


    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(wac)
//                .apply(springSecurity())
                .build();
        MockitoAnnotations.initMocks(this);
    }

}
