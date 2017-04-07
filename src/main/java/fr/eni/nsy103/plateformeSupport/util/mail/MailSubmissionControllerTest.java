package fr.eni.nsy103.plateformeSupport.util.mail;

import javax.ws.rs.core.Application;

import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
/*
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MailSubmissionControllerTest {

    private Wiser wiser;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        wiser = new Wiser();
        wiser.start();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception {
        wiser.stop();
    }

    @Test
    public void send() throws Exception {
        // act
        mockMvc.perform(get("/mail"))
                .andExpect(status().isCreated());
        // assert
        assertReceivedMessage(wiser)
                .from("someone@localhosts")
                .to("someone@localhost")
                .withSubject("Lorem ipsum")
                .withContent("Lorem ipsum dolor sit amet [...]");
    }
}
*/