package com.example.springboot;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.example.springboot.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootRestExampleApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/user", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());

	}
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setDob(user.getDob());
		user.setJoiningDate(user.getJoiningDate());
		user.setEmail(user.getEmail());
		user.setAddress(user.getAddress());
		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/save", user, User.class);
		assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testUpateUser() {
		User u = new User();
		Long id = u.getId();
		u = restTemplate.getForObject(getRootUrl() +  "/update"+id, User.class);
		u.setFirstName(u.getFirstName());
		u.setLastName(u.getLastName());
		u.setDob(u.getDob());
		u.setJoiningDate(u.getJoiningDate());
		u.setEmail(u.getEmail());
		u.setAddress(u.getAddress());
		restTemplate.put(getRootUrl() +  "/update"+id, u);
		User updateUser = restTemplate.getForObject(getRootUrl() +  "/update"+id, User.class);
		assertNotNull(updateUser);
	}
	
	@Test
    public void testDeleteUser() {
		User u = new User();
		Long id = u.getId();
        u = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
         assertNotNull(u);
         restTemplate.delete(getRootUrl() + "/user/" + id);
         try {
              u = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
