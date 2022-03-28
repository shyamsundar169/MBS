package com.MBS.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MBS.exception.InvalidEmailException;
import com.MBS.exception.InvalidMobilenoException;
import com.MBS.model.User;
import com.MBS.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;	

	public String addUser(User a)
	{
		try {
			//System.out.println(a.getEmailid());

			if(a.getEmailid() == null || !isValid(a.getEmailid()) )
			{
				return "Invalid EmailId";
			}

			if(a.getMobileno() == null || !isValidMobile(a.getMobileno().toString()))
			{
				return "Invalid Mobile number";
			}
			if(a.getPassword() == null || a.getConfirmpassword() == null || !a.getPassword().equals(a.getConfirmpassword()))
			{
				return "Password and confirm password does not match";
			}
			return "User resigestration sucessuflly";
		}
		catch(InvalidEmailException e) {
			return "Invalid EmailId";
		}
		catch(InvalidMobilenoException e) {
			return "Invalid Mobile number";
		}
		catch(Exception e) {
			return "Something went wrong, try again";
		}

	}
	public static boolean isValid(String emailId) throws Exception
	{
		try{
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
					"[a-zA-Z0-9_+&*-]+)*@" +
					"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
					"A-Z]{2,7}$";                            
			Pattern pat = Pattern.compile(emailRegex);

			return pat.matcher(emailId).matches();

		}catch (Exception e) {
			throw new InvalidEmailException("Invalid Email id");
		}
	}

	public static boolean isValidMobile(String mobileno) throws Exception
	{
		try {
			Pattern p = Pattern.compile("^\\d{10}$");
			Matcher m = p.matcher(mobileno);
			return (m.matches());
		}catch (Exception e) {
			throw new InvalidMobilenoException("Invalid Mobile number");
		}
	}
	public static boolean isValidPassword(String password)
	{
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=])"
				+ "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher mm = p.matcher(password);    
		return mm.matches();
	}
}





