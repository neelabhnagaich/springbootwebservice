package com.neelabh.rest.restfullwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users  = new ArrayList<>();
	
	private static int usersCount = 0;
	
	static { 
		users.add(new User(++usersCount, "neelabh", LocalDate.now().minusYears(10)));
		users.add(new User(++usersCount, "ashish", LocalDate.now().minusYears(15)));
		users.add(new User(++usersCount, "abhishek", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		Predicate<? super User> predicate  = user -> user.getId() == id;
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	public User save(User user){
		user.setId(++usersCount);
		users.add(user);
		return user;
		
	}

	public void deleteById(int id){
		Predicate<? super User> predicate  = user -> user.getId() == id;
		users.removeIf(predicate);
	}

}
