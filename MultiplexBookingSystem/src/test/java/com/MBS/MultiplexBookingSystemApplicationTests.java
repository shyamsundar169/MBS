package com.MBS;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.MBS.model.User;
import com.MBS.service.UserService;

@SpringBootTest
class MultiplexBookingSystemApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void checkInValidEmail() throws Exception{
	      User u = new User();
	      u.setUserid(1);
	      u.setName("Shyam");
	      u.setMobileno(9003429757L);
	      u.setEmailid("shyam");
	      u.setDateofbirth(new SimpleDateFormat("yyyy-MM-dd").parse("1994-06-03"));
	      u.setPassword("testPass");
	      u.setConfirmpassword("testPass");
	      assertEquals("Invalid EmailId", userService.addUser(u));
	   }
	
	@Test
	public void checkInValidMobileNo() throws Exception{
	      User u = new User();
	      u.setUserid(1);
	      u.setName("Shyam");
	      u.setMobileno(9003429757789L);
	      u.setEmailid("shyam@gmail.com");
	      u.setDateofbirth(new SimpleDateFormat("yyyy-MM-dd").parse("1994-06-03"));
	      u.setPassword("testPass");
	      u.setConfirmpassword("testPass");
	      assertEquals("Invalid Mobile number", userService.addUser(u));
	   }
	
	@Test
	public void checkPasswordAndConfirmPassword() throws Exception{
	      User u = new User();
	      u.setUserid(1);
	      u.setName("Shyam");
	      u.setMobileno(9003429757L);
	      u.setEmailid("shyam@gmail.com");
	      u.setDateofbirth(new SimpleDateFormat("yyyy-MM-dd").parse("1994-06-03"));
	      u.setPassword("testPass");
	      u.setConfirmpassword("testPass12");
	      assertEquals("Password and confirm password does not match", userService.addUser(u));
	   }

}
