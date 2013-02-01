package org.zenika.skillz.web.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.zenika.skillz.model.Consultant;
import org.zenika.skillz.repositories.ConsultantRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.zenika.skillz.model.builders.ConsultantBuilder.aConsultant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class ConsultantControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void helloWorld() throws Exception {
        mockMvc.perform(
                get("/consultant").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$[0].firstName").value("Sébastien"));

    }

    @Test
    public void getById_should_return_a_Consultant() throws Exception {
        mockMvc.perform(
                get("/consultant/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("firstName").value("Sébastien"));

    }


    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {

        @Bean
        public ConsultantController consultantController() {
            return new ConsultantController();
        }

        @Bean
        public ConsultantRepository consultantRepository() {
            ConsultantRepository consultantRepository = mock(ConsultantRepository.class);
            when(consultantRepository.findAll()).thenReturn(createConsultants());
            when(consultantRepository.findById(1)).thenReturn(createConsultant());
            return consultantRepository;
        }

        Collection<Consultant> createConsultants() {
            Consultant consultant = aConsultant().withFirstName("Sébastien").build();
            List<Consultant> consultantList = new ArrayList<Consultant>();
            consultantList.add(consultant);
            return consultantList;
        }

        Consultant createConsultant() {
            return aConsultant().withFirstName("Sébastien").build();
        }


    }
}