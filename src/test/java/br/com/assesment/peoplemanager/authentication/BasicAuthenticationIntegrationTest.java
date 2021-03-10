package br.com.assesment.peoplemanager.authentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import br.com.assesment.peoplemanager.PeopleManagerApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, classes = PeopleManagerApplication.class)
public class BasicAuthenticationIntegrationTest {

//    TestRestTemplate restTemplate;
//    URL base;
//
//    @LocalServerPort
//    int port;
//
//    @Before
//    public void setUp() throws MalformedURLException {
//        restTemplate = new TestRestTemplate("admin", "admin");
//        base = new URL("http://localhost:" + port + "/api/v1/auth/login");
//    }
//
//    @Test
//    public void whenLoggedUserRequestsHomePage_ThenSuccess() throws IllegalStateException {
//        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertTrue(response
//                .getBody()
//                .contains(""));
//    }
//
//    @Test
//    public void whenUserWithWrongCredentials_thenUnauthorizedPage() throws IllegalStateException, IOException {
//        restTemplate = new TestRestTemplate("user", "wrongpassword");
//        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
//
//        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
//        assertNull(response.getBody());
//    }

}
