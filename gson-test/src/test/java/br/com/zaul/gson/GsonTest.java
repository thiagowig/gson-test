package br.com.zaul.gson;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.zaul.gson.model.Role;
import br.com.zaul.gson.model.User;

import com.google.gson.Gson;

public class GsonTest {

	private static Gson gson;
	private static User user;
	private static String generatedJson;
	
	@BeforeClass
	public static void init() {
		generatedJson = "{\"name\":\"Thiago\",\"age\":29,\"roles\":[{\"name\":\"ADMIN\"},{\"name\":\"SUPERVISOR\"},{\"name\":\"USER\"}]}";
		
		gson = new Gson();
		
		user = new User();
		user.setName("Thiago");
		user.setAge(29);
		user.setRoles(new ArrayList<Role>());
		
		user.getRoles().add(createRole("ADMIN"));
		user.getRoles().add(createRole("SUPERVISOR"));
		user.getRoles().add(createRole("USER"));
	}
	
	@Test
	public void shouldBeTheSameJson() {
		Assert.assertEquals(generatedJson, gson.toJson(user));
	}
	
	@Test
	public void shouldBeTheSameUser() {
		User user = gson.fromJson(generatedJson, User.class);
		
		Assert.assertEquals("Thiago", user.getName());
		Assert.assertEquals(new Integer(29), user.getAge());
	}
	
	private static Role createRole(String name) {
		Role role = new Role();
		role.setName(name);
		
		return role;
	}
}
