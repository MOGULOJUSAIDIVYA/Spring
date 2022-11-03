package com.example.springcrud;

import com.example.springcrud.model.Employee;
import com.example.springcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstName("Sai Divya");
		employee.setLastName("Moguloju");
		employee.setEmailId("saidivya.moguloju@gmail.com");
		employeeRepository.save(employee);

		Employee employee1=new Employee();
		employee.setId(2);
		employee1.setFirstName("Prathyusha");
		employee1.setLastName("Moguloju");
		employee1.setEmailId("prathyusha.moguloju@gmail.com");
		employeeRepository.save(employee);

	}
}
