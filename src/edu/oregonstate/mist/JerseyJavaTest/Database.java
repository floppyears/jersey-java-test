package edu.oregonstate.mist.JerseyJavaTest;

import java.util.HashMap;

public class Database {

	private HashMap<Integer,Employee> db;

	/**
	 * Initialize the database with sample data
	 */
	public Database() {
		db = initialize(new HashMap<Integer,Employee>());
	}

	/**
	 * Read Employee
	 *
	 * @param	id	unique identifier
	 * @return		matching Employee instance or null if none found
	 */
	public Employee getEmployeeById(Integer id) {
		return db.get(id);
	}

	/**
	 * Create or Update Employee
	 *
	 * @param	employee	instance to be added to database
	 */
	public void setEmployee(Employee employee) {
		db.put(employee.getId(), employee);
	}

	/**
	 * Initialize database with sample data
	 *
	 * @param	db	HashMap<Integer,Employee> variable or instance
	 */
	private HashMap<Integer,Employee> initialize(HashMap<Integer,Employee> db) {
		Integer i;
		Employee e;

		i = 1;
		e = new Employee(i);
		e.setOsuId("123456789");
		e.setLastName("Doe");
		e.setFirstName("John");
		e.setMiddleInitial("A");
		e.setOnidLoginId("dojo");
		e.setEmailAddress("dojo@onid.orst.edu");
		e.setEmployeeStatus("A");
		db.put(i, e);

		i = 2;
		e = new Employee(i);
		e.setOsuId("234567891");
		e.setLastName("Doe");
		e.setFirstName("Jane");
		e.setMiddleInitial("B");
		e.setOnidLoginId("doja");
		e.setEmailAddress("doja@onid.orst.edu");
		e.setEmployeeStatus("A");
		db.put(i, e);

		i = 3;
		e = new Employee(i);
		e.setOsuId("345678912");
		e.setLastName("Smith");
		e.setFirstName("George");
		e.setMiddleInitial("R");
		e.setOnidLoginId("smge");
		e.setEmailAddress("smge@onid.orst.edu");
		e.setEmployeeStatus("A");
		db.put(i, e);

		return db;
	}
}
