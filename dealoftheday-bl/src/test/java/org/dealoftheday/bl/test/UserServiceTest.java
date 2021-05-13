package org.dealoftheday.bl.test;

import static org.dealoftheday.bl.domain.Role.ROLE_ADMIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import static org.dealoftheday.bl.test.util.TestUtils.createUser;
import static org.dealoftheday.bl.test.util.TestUtils.updateUser;

import org.dealoftheday.bl.domain.Role;
import org.dealoftheday.bl.domain.User;
import org.dealoftheday.bl.service.RoleService;
import org.dealoftheday.bl.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractSpringTest {
	
	@Autowired
	private  UserService  userService;
	
	@Autowired
	private  RoleService  roleService;
	
	@Test
	public void test_getUser_withoutRole() {
		// Given
		final String username = "user2";

		// When
		User user = userService.get(username);

		// Then
		assertNotNull(user);
		assertEquals("user2", user.getUserName());
		assertEquals("User2Name", user.getName());
		assertEquals("User2Surname", user.getSurname());
		assertEquals("user2@hotmail.it", user.getEmail());
		assertEquals("user2", user.getPwd());
		assertEquals(false, user.getEnabled());
		assertEquals(true, user.getLocked());
		assertEquals(0, user.getFailedLoginCount());
		assertEquals(0, user.getRoles().size());
	}

	@Test
	public void test_getUser_withRoles() {
		// Given
		final String username = "admin";
		final Role adminRole = new Role(ROLE_ADMIN, "Administrator", "Full access and control");

		// When
		User user = userService.get(username);

		// Then
		assertNotNull(user);
		assertEquals("admin", user.getUserName());
		assertEquals("AdminName", user.getName());
		assertEquals("AdminSurname", user.getSurname());
		assertEquals("sandrus88@hotmail.it", user.getEmail());
		assertEquals("admin", user.getPwd());
		assertEquals(true, user.getEnabled());
		assertEquals(false, user.getLocked());
		assertEquals(0, user.getFailedLoginCount());
		assertEquals(1, user.getRoles().size());
		assertEquals(adminRole, user.getRoles().get(0));
	}

	@Test
	public void test_getAllUsers() {
		// Given
		final Role adminRole = new Role(ROLE_ADMIN, "Administrator", "Full access and control");
		final User adminUser = new User("admin", "AdminName", "AdminSurname"
				, "sandrus88@hotmail.it", "admin"
				, true, false, 0, Arrays.asList(adminRole));

		// When
		List<User> users = userService.getAll();
		User dbAdminUser = users.get(0);

		// Then
		assertNotNull(users);
		assertEquals(users.size(), 10);

		assertEquals(adminUser, dbAdminUser);
		assertEquals(1, dbAdminUser.getRoles().size());  // verifico che abbia un solo ruolo.
		assertEquals(adminRole, dbAdminUser.getRoles().get(0)); //verifico che il ruolo assocciato sia ADMIN_ROLE
	}

	@Test
	public void test_getUser_notPresent() {
		// Given
		final String userName = "fakeUserNotPresent";

		// When
		User user = userService.get(userName);

		// Then
		assertNull(user);
	}

	@Test
	public void test_searchAllUsers() {
		// Given
		User searchBean = new User();

		// When
		List<User> list = userService.searchUser(searchBean);

		// Then
		assertEquals(10, list.size());
	}

	@Test
	public void test_searchUsers_fullMatch() {
		// Given
		User searchBean = new User();
		searchBean.setName("User2Name");
		searchBean.setSurname("User2Surname");
		searchBean.setEmail("user2@hotmail.it");

		// When
		List<User> list = userService.searchUser(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchUsers_partialMatch() {
		// Given
		User searchBean = new User();
		searchBean.setName("uSer2");
		searchBean.setSurname("2Surname");
		searchBean.setEmail("uSer2@hotmail.it");

		// When
		List<User> list = userService.searchUser(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchUsers_byName() {
		// Given
		User searchBean = new User();
		searchBean.setName("User2Name");

		// When
		List<User> list = userService.searchUser(searchBean);

		// Then
		assertEquals(1, list.size());
	}
	
	@Test
	public void test_searchUsers_bySurname() {
		// Given
		User searchBean = new User();
		searchBean.setSurname("User2Surname");

		// When
		List<User> list = userService.searchUser(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchUsers_byEmail() {
		// Given
		User searchBean = new User();
		searchBean.setEmail("user2@hotmail.it");
		// When
		List<User> list = userService.searchUser(searchBean);
		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_insertUser() {
		// Given
		User user = createUser();

		// When
		user = userService.insert(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
	}
	
	@Test
	public void test_insertUserWithRoles() {
		// Given
		User user = createUser();
		final Role roleAdmin = new Role(ROLE_ADMIN);
		
		// When
		user.addRole(roleAdmin);
		user = userService.insert(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(1, user.getRoles().size());
		assertEquals(new Integer(ROLE_ADMIN), user.getRoles().get(0).getId());
	}


	@Test
	public void test_updateUser() {
		// Given
		final String userName = "user3";
		final String updatedName = "updatedName";

		// When
		User user = userService.get(userName);
		updateUser(user);
		user = userService.update(user);
		User userDb = userService.get(userName);

		// Then
		assertEquals(userDb, user);
		assertEquals(updatedName, user.getName());
	}
	
//	@Test
//	public void test_updateRoles_forUsers() {
//		// Given
//		String username = "admin";
//		int role1 = 7;
//		Role role1Obj = new Role(role1);
//		role1Obj = roleService.insert(role1Obj);
//
//		// When
//		User user = userService.get(username);
//		user.addRole(role1Obj);
//		user = userService.update(user);
//		User userDb = userService.get(user.getUserName());
//
//		// Then
//		assertEquals(userDb, user);
//		assertEquals(2, user.getRoles().size());
//		assertEquals(new Integer(1), user.getRoles().get(0).getId());
//	}
	
//	@Test
//	public void test_updateUser_removeRoles() {
//		// Given
//		String username = "admin";
//		int role1 = 1;
//		final Role role1Obj = roleService.get(role1);
//
//		// When
//		User user = userService.get(username);
//		user.removeRole(role1Obj);
//		user = userService.update(user);
//		User userDb = userService.get(username);
//
//		// Then
//		assertEquals(userDb, user);
//		assertTrue(userDb.getRoles().isEmpty());
//	}

	@Test
	public void test_deleteUser_withoutRoles() {
		// Given
		final String user_userName = "admin10";

		// When
		boolean deleting = userService.delete(user_userName);
		User user = userService.get(user_userName);

		// Then
		assertTrue(deleting);
		assertNull(user);
	}

	@Test
	public void test_deleteUser_withRoles_shouldRemoveUserButNotRoles() {
		// Given
		String username = "admin";
		int role1 = 1;
		final Role role1Obj = roleService.get(role1);

		// When
		boolean deleting = userService.delete(username);
		User user = userService.get(username);

		// Then
		assertTrue(deleting);
		assertNull(user);
		assertNotNull(role1Obj);
	}

	@Test
	public void test_deleteUser_notPresent() {
		// Given
		final String user_userName = "";

		// When
		boolean deleting = userService.delete(user_userName);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_user_integrationTest_CRUD() {
		// 1. insert a new user
		User user = createUser();
		user = userService.insert(user);
		assertNotNull(user.getUserName());

		// 2. get the user from DB
		User userDb = userService.get(user.getUserName());
		assertNotNull(userDb);
		assertEquals(userDb, user);

		// 3. Update the user in DB, and Get to check if updated correctly
		updateUser(user);
		user = userService.update(user);
		userDb = userService.get(user.getUserName());
		assertEquals(userDb, user);

		// 4. Delete the user from DB, and Get to check if deleted correctly
		boolean isRemoved = userService.delete(user.getUserName());
		assertTrue(isRemoved);
		userDb = userService.get(user.getUserName());
		assertNull(userDb);
	}

}
