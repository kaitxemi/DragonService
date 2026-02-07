package dragonEntrenoServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.txe.dragonentrenoservice.DragonEntrenosServiceApplication;


@AutoConfigureMockMvc
@SpringBootTest(classes = DragonEntrenosServiceApplication.class)
public class SesionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception {
       
    }
}