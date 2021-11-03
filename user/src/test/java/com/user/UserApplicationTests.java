package com.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.user.model.UserModel;
import com.user.repository.UserRepository;

@SpringBootTest
class UserApplicationTests {
	
	@Autowired
	private UserRepository userRepo;

	@Test
	public void testRegistration() {
		UserModel user=new UserModel();
		user.setName("Vineet");
		user.setEmail("vineet@gmail.com");
		user.setAddress("Varanasi");
		user.setPhone("8976439976");
		userRepo.save(user);
		assertThat(user.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testUserById() {
		Long id=(long) 1;
		UserModel user=userRepo.getById(id);
		assertEquals(1, user.getId());
	}
	
	@Test
	public void testUpdate()
	{
		Long id=(long) 1;
		UserModel user=userRepo.findById(id).get();
		user.setName("Ashvani");
		userRepo.save(user);
		assertEquals("Ashvani", userRepo.findById(id).get().getName());
	}
	
	@Test
	public void testSearchUser() {
		String email="vineet@gmail.com";
		String name="Ashvani";
		assertEquals(email, userRepo.getByNameAndEmail(name, email).get(0).getEmail());
	}
	
	@Test
	public void testDelete() {
		Long id=(long) 1;
		userRepo.deleteById(id);
		assertThat(userRepo.existsById(id)).isFalse();
	}
	
}
