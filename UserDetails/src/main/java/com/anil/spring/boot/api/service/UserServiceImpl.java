package com.anil.spring.boot.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.anil.spring.boot.api.model.User;

@Service
public class UserServiceImpl {

	private static final AtomicLong counter = new AtomicLong();

	private static List<User> users;
	static {
		users = listOfUsers();
	}

	public List<User> findAllUsers() {

		return users;
	}

	public static List<User> listOfUsers() {
		List<User> listUsers = new ArrayList<User>();
		// CopyOnWriteArrayList<User> listUsers = new CopyOnWriteArrayList<User>();
		listUsers.add(new User(counter.incrementAndGet(), "Anil", 29, 50000));
		listUsers.add(new User(counter.incrementAndGet(), "Rakesh", 31, 1000));
		listUsers.add(new User(counter.incrementAndGet(), "Hari", 30, 45000));
		listUsers.add(new User(counter.incrementAndGet(), "Abinash",33, 44000));
		listUsers.add(new User(counter.incrementAndGet(), "Suda", 30, 65000));
		listUsers.add(new User(counter.incrementAndGet(), "Manshi", 25, 35000));
		listUsers.add(new User(counter.incrementAndGet(), "Pragyna", 28, 75000));
		listUsers.add(new User(counter.incrementAndGet(), "Babul", 27, 64000));
		listUsers.add(new User(counter.incrementAndGet(), "Chiku", 21, 6000));
		listUsers.add(new User(counter.incrementAndGet(), "Shakti", 22, 50009));
		listUsers.add(new User(counter.incrementAndGet(), "chui", 4, 5000));
		listUsers.add(new User(counter.incrementAndGet(), "welsi", 5, 100));
		listUsers.add(new User(counter.incrementAndGet(), "Debashi Dash", 15, 10011));
		listUsers.add(new User(counter.incrementAndGet(), "RameshMajhi", 17, 200));
		listUsers.add(new User(counter.incrementAndGet(), "SarojiniNaidu", 68, 11200));
		
		return listUsers;
	}

	public User findById(Long id) {
		// TODO Auto-generated method stub
		for (User user : users) {
			Long userId = user.getId();
			if (userId == id) {
				return user;
			}
		}
		return null;
	}

	public User findByName(String name) {
		for (User user : users) {
			String username = user.getName();
			if (username.equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public User isExits() {
		for (User user : users) {
			if (!StringUtils.isEmpty(user))
				return user;
		}
		return null;
	}

	public User isUserExist(User user) {
		for (User alluser : users) {
			//if (alluser.getId() == user.getId() || alluser.equals(user)) {
			if (alluser.getId() == user.getId() || alluser.getName().equalsIgnoreCase(user.getName())) {
				return null;
			}
		}
		return user;
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		Iterator<User> itr = users.iterator();
		itr.hasNext();
		while (itr.hasNext()) {
			User alluser = itr.next();
			if (alluser.getId() == id) {

				itr.remove();
			}
		}
	}

	public void findAllUser() {
		users.clear();
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		// user.setId(counter.incrementAndGet());
		users.add(user);
	}
}