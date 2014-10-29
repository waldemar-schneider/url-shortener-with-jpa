package de.wschneider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Configurable
public class AdditionalTestConfiguration {


    @Autowired
    private WebApplicationContext wac;

    @Bean
    public MockMvc mockMvc() {
        return MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

}
