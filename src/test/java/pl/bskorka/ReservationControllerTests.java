package pl.bskorka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * Created by sages on 14.11.16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReservationControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testImageReturn() throws Exception {
        // when
        this.mockMvc.perform(get("/reservations/1"))
                .andDo(print())
        // then
                .andExpect(jsonPath("@.name").value("Bartek"))
                .andExpect(jsonPath("@._links.photo.href").exists());
    }

}
