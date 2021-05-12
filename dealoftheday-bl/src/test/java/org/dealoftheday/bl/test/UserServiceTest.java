package org.dealoftheday.bl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
	public void test_getUser_byUsername() {
		// Given
		final String username = "admin";

		// When
		User user = userService.get(username);

		// Then
		System.out.println("user: " + user);
		assertNotNull(user);
	}
//
//	@Test
//	public void test_getCourse_withTopics() {
//		// Given
//		final String user_userName = 1;
//		final Role topic = new Role(301, "Objects Oriented Paradigm",
//				"OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)", user_userName);
//
//		// When
//		User user = userService.getCourse(user_userName);
//
//		// Then
//		assertNotNull(user);
//		assertNotNull(user.getTopics());
//		assertEquals(5, user.getTopics().size());
//
//		assertNotNull(user.getTopics().get(0));
//		assertEquals(topic, user.getTopics().get(0));
//	}
//
//	@Test
//	public void test_getAllCourses() {
//		// Given
//		final String[] topicsId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//
//		// When
//		List<User> courses = userService.getAllCourses();
//
//		// Then
//		assertNotNull(courses);
//		assertEquals(courses.size(), 10);
//		assertEquals(courses.get(0).getId(), topicsId[0]);
//		assertEquals(courses.get(9).getId(), topicsId[9]);
//	}

//	@Test
//	public void test_getCourse_notPresent() {
//		// Given
//		final String user_userName = -1;
//
//		// When
//		User user = userService.getCourse(user_userName);
//
//		// Then
//		assertNull(user);
//	}
//
//	@Test
//	public void test_searchAllCourses() {
//		// Given
//		User searchBean = new User();
//
//		// When
//		List<User> list = userService.searchCourse(searchBean);
//
//		// Then
//		assertEquals(10, list.size());
//	}
//
//	@Test
//	public void test_searchCourses_fullMatch() {
//		// Given
//		User searchBean = new User();
//		searchBean.setId(1);
//		searchBean.setName("Java");
//		searchBean.setEnabled(true);
//
//		// When
//		List<User> list = userService.searchCourse(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}
//
//	@Test
//	public void test_searchCourses_partialMatch() {
//		// Given
//		User searchBean = new User();
//		searchBean.setName("Ja");
//
//		// When
//		List<User> list = userService.searchCourse(searchBean);
//
//		// Then
//		assertEquals(3, list.size());
//	}
//
//	@Test
//	public void test_searchCourses_byName() {
//		// Given
//		User searchBean = new User();
//		searchBean.setName("Computer Network");
//
//		// When
//		List<User> list = userService.searchCourse(searchBean);
//
//		// Then
//		assertEquals(1, list.size());
//	}
//
//	@Test
//	public void test_searchCourses_byEnabled() {
//		// Given
//		User searchBean = new User();
//		searchBean.setEnabled(false);
//		// When
//		List<User> list = userService.searchCourse(searchBean);
//		// Then
//		assertEquals(5, list.size());
//
//		searchBean.setEnabled(true);
//		list = userService.searchCourse(searchBean);
//		assertEquals(5, list.size());
//	}

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
	public void test_updateRoles_fromDb_forUsers() {
		// Given
		String username = "admin";
		int role1 = 2;
		final Role role1Obj = roleService.get(role1);
		
		// When
		User user = userService.get(username);
		user.addRole(role1Obj);
		user = userService.update(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(2, user.getRoles().size());
		assertEquals(new Integer(1), user.getRoles().get(0).getId());
	}
	
	@Test
	public void test_updateRoles_forUsers() {
		// Given
		String username = "admin";
		int role1 = 2;
		String admin = "Editor";
		String adminDesc  = "Description of Editor";
		final Role role1Obj = new Role(role1, admin, adminDesc);
		
		// When
		User user = userService.get(username);
		user.addRole(role1Obj);
		user = userService.update(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(2, user.getRoles().size());
		assertEquals(new Integer(1), user.getRoles().get(0).getId());
	}
	
	@Test
	public void test_insertUserWithRoles() {
		// Given
		User user = createUser();
		int role1 = 2;
		final Role role1Obj = roleService.get(role1);
		
		// When
		user = userService.insert(user);
		user.addRole(role1Obj);
		user = userService.update(user);
		User userDb = userService.get(user.getUserName());

		// Then
		assertEquals(userDb, user);
		assertEquals(1, user.getRoles().size());
		assertEquals(new Integer(2), user.getRoles().get(0).getId());
	}

//	@Test
//	public void test_updateCourse() {
//		// Given
//		final String user_userName = 1;
//
//		// When
//		User user = userService.get(user_userName);
//		updateCourse(user);
//		user = userService.update(user);
//		User userDb = userService.get(user_userName);
//
//		// Then
//		assertEquals(userDb, user);
//		assertNotNull(userDb.getTopics());
//		assertEquals(5, userDb.getTopics().size());
//		assertEquals(new String(301), userDb.getTopics().get(0).getId());
//		assertEquals("Objects Oriented Paradigm", userDb.getTopics().get(0).getName());
//	}
//
//	@Test
//	public void test_updateCourse_addTopics() {
//		// Given
//		final String user_userName = 10;
//		Role topic = roleService.getTopic(308);
//		Role topic2 = roleService.getTopic(309);
//		Role topic3 = roleService.getTopic(310);
//
//		// When
//		User user = userService.getCourse(user_userName);
//		user.addTopic(topic);
//		user.addTopic(topic2);
//		user.addTopic(topic3);
//		user = userService.update(user);
//		User userDb = userService.getCourse(user_userName);
//
//		// Then
//		assertEquals(userDb, user);
//		assertNotNull(userDb.getTopics());
//		assertEquals(3, userDb.getTopics().size());
//	}
//	
//	@Test
//	public void test_updateCourse_removeTopics() {
//		// Given
//		final String user_userName = 1;
//		Role topic = new Role(301, "Objects Oriented Paradigm", "OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)", 1);
		
//		// When
//		User user = userService.getCourse(user_userName);
//		user.removeTopic(topic);
//		user = userService.update(user);
//		User userDb = userService.getCourse(user_userName);
//		
//		// Then
//		assertEquals(userDb, user);
//		assertNotNull(userDb.getTopics());
//		assertEquals(4, userDb.getTopics().size());
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

//	@Test
//	public void test_deleteUser_withRoles_shouldRemoveUserButNotRoles() {
//		// Given
//		final String user_userName = "User2";
//		final String roleSubscriber = "Subscriber";
//		final String roleViewer = "Viewer";
//
//		// When
//		boolean deleting = userService.delete(user_userName);
//		User user = userService.get(user_userName);
//		Role role = roleService.get(roleSubscriber);
//		Role role2 = roleService.get(roleViewer);
//
//		// Then
//		assertTrue(deleting);
//		assertNull(user);
//		assertNotNull(role);
//		assertNotNull(role2);
//	}
//	
//	@Test
//	public void test_deleteRole_fromUser_shouldRemoveRoleButNotUser() {
//		// Given
//		final String user_userName = "User2";
//		final String roleSubscriber = "Subscriber";
//		final String roleViewer = "Viewer";
//
//		// When
//		User user = userService.get(user_userName);
//		boolean deleting = roleService.delete(roleSubscriber);
//		user = userService.update(user);
//		Role role = roleService.get(roleSubscriber);
//		Role role2 = roleService.get(roleViewer);
//
//		// Then
//		assertTrue(deleting);
//		assertNotNull(user);
//		assertNull(role);
//		assertNotNull(role2);
//		assertEquals(1, user.getRoles().size());
//	}

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
