import com.ftc.fia.controller.TestController;
import com.ftc.fia.domain.TestMe;
import com.ftc.fia.service.ITestMeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Zelalem Belay on 12/21/2016.
 */

public class DemoTester
{

    @Mock
    private ITestMeService iTestMeService;

    @InjectMocks
    private TestController testController;

    private MockMvc mockmvc;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockmvc = MockMvcBuilders.standaloneSetup(testController).build();
    }


    @Test
    public void testTest() throws Exception {
        List<TestMe> tests = new ArrayList<>();
        tests.add(new TestMe());
        tests.add(new TestMe());
        tests.add(new TestMe());

        when(iTestMeService.getTests()).thenReturn(tests);

        mockmvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("test"))
                .andExpect(model().attribute("tests", hasSize(3)));
    }

}
