package adamd.javaarchdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ApplicationIT {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void givenAppCanBootAndGetDataFromDB() throws Exception {
        // Standard smoke test
        mockMvc.perform(get("/cats").accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk()).andExpect(jsonPath("$..race",
          contains(equalTo("siamese"), equalTo("persian"))));
    }
    
}
