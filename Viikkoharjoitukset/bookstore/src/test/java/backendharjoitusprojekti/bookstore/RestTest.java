package backendharjoitusprojekti.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class RestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBooksWithoutAuth() throws Exception {
        mockMvc.perform(get("/books")).andExpect(status().isOk());
    }

    @Test
    public void testPostBook() throws Exception {
        String newBookJson = """
            {
                "title":"Testausta",
                "author":"Testaaja",
                "publicationYear":2026,
                "isbn":"123456-7",
                "price":"13,37",
                "category":{"name":"Comedy",
                            "categoryId":3}
            }
            """;

            mockMvc.perform(post("/books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(newBookJson))
                    .andExpect(status().isOk());
    }

}
