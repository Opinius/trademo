package com.alexeus.trademo.controller;

import com.alexeus.trademo.domain.FactoryObject;
import com.alexeus.trademo.service.FactoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FactoryController.class)
public class FactoryControllerTest {
    private static final String OBJECT_NAME = "objectName";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FactoryService factoryService;

    @WithMockUser
    @Test
    public void whenListObjects_thenReturnJsonArray()
            throws Exception {

        FactoryObject obj = new FactoryObject();
        obj.setName(OBJECT_NAME);

        given(factoryService.listObjects()).willReturn(Collections.singletonList(obj));

        mvc.perform(get("/factory/object/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(OBJECT_NAME)));
    }
}
