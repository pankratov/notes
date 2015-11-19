package ru.pankratov.notes.presentation.rest;

import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import ru.pankratov.notes.domain.Note;
import ru.pankratov.notes.presentation.config.AppConfig;
import ru.pankratov.notes.presentation.config.RestConfig;
import ru.pankratov.notes.presentation.config.TestAppConfig;
import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"integration", "db"})
@ContextConfiguration(classes = {RestConfig.class, AppConfig.class, TestAppConfig.class})
@WebAppConfiguration
public class NotesControllerIT {
	
    @Autowired
    private WebApplicationContext context;

    @Before 
    public void setUp() {
        RestAssuredMockMvc.webAppContextSetup(context);
    }

    @After 
    public void tearDown() {
        RestAssuredMockMvc.reset();
    }
	
	@Test
	public void testGetAndSave() {
		get("/rest/notes").then()
			.statusCode(HttpStatus.SC_OK)
			.body(equalToIgnoringWhiteSpace("[]"));

		Note note1 = new Note();
		note1.setTitle("title1");
		note1.setBody("simple body");
		
		given()
			.contentType(ContentType.JSON)
			.body(note1)
		.when()
			.post("/rest/notes")
		.then()
			.statusCode(HttpStatus.SC_OK);
		
		get("/rest/notes")
		.then()
			.body("title", hasItems(equalTo("title1")));
		
	}
}
