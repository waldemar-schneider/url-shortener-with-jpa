package de.wschneider.web;

import de.wschneider.AdditionalTestConfiguration;
import de.wschneider.Application;
import de.wschneider.entity.UrlEntity;
import de.wschneider.entity.UrlRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {Application.class, AdditionalTestConfiguration.class})
public class UrlControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UrlRepository urlRepository;

    @Before
    public void setUp() throws Exception {
        final UrlEntity urlEntity = new UrlEntity();
        urlEntity.setHash("Ha123");
        urlEntity.setUrl("https://blog.flavia-it.de");
        urlRepository.save(urlEntity);
    }

    @Test
    public void testFindAllUrls() throws Exception {
        // when
        final ResultActions perform = this.mockMvc.perform(get("/url/"));

        // then
        perform.andExpect(status().isOk())
                .andExpect(model().attribute("urls", notNullValue()))
                .andExpect(model().attribute("urls", hasSize(1)))
                ;
    }
}