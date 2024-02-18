package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@SpringBootApplication
public class CrudprojApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CrudprojApplication.class, args);
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		System.out.println("Enter the choice for operation");
		boolean op = true;
		Scanner sc = new Scanner(System.in);
		while (!op) {
			System.out.println("Press 1 for Insert data");
			System.out.println("Press 2 for Read 1 data");
			System.out.println("Press 3 for Read All data");
			System.out.println("Press 4 for Update data");
			System.out.println("Press 5 for Delete data");
			System.out.println("Press 6 for exit");
			int inp = sc.nextInt();
			sc.nextLine();
			switch (inp) {
			case 1:// insert data
				Employee emp = new Employee();
			
				System.out.println("Enter Employee name");
				String name = sc.nextLine();
				System.out.println("Enter Employee name is: "+name);
				emp.setName(name);
				sc.nextLine();
				System.out.println("Enter Employee role");
				
				String role = sc.nextLine();
				emp.setRole(role);
				Employee result = employeeRepository.save(emp);
				System.out.println("insert data is: " + result);

				break;
			case 2: // read only one value
				System.out.println("Enter Employee Id");
				Integer id = sc.nextInt();
				Optional<Employee> emp1 = employeeRepository.findById(id);
				System.out.println(emp1);
				break;

			case 3:
				// read all the dates
				Iterable<Employee> itr = employeeRepository.findAll();
				itr.forEach(e -> {
					System.out.println(e);
				});

				break;
			case 4:// update the data
				System.out.println("Enter Employee Id");
				Integer id1 = sc.nextInt();
				Optional<Employee> empo = employeeRepository.findById(id1);
				Employee empu = empo.get();
				sc.nextLine();
				System.out.println("Enter Employee name for update");
				String uname = sc.nextLine();
				empu.setName(uname);
				sc.nextLine();
			
				
				System.out.println("Enter Employee role for update");
				String role1 = sc.nextLine();
				empu.setRole(role1);
				Employee results = employeeRepository.save(empu);
				System.out.println(results);
				break;
			case 5://delete data by id
				System.out.println("Enter Employee Id");
				Integer id_del = sc.nextInt();
				employeeRepository.deleteById(id_del);
				System.out.println("delete done!!!!");
				break;
				
			case 6:
				op = true;
				break;

			}
		}
		//custom finder method
		System.out.println("_______________BYNAME_______________");
		List<Employee> employee=employeeRepository.findByName("pl");
		employee.forEach(e->{System.out.println(e);});
		System.out.println("_______________AND_______________");
		List<Employee> list1=employeeRepository.findByNameAndRole("pl", "devoops");
		list1.forEach(e1->{System.out.println(e1);});
		System.out.println("______________OR________________");
		List<Employee>list2=employeeRepository.findByNameOrRole("nj", "tester");
		list2.forEach(e3->{System.out.println(e3);});
		System.out.println("______________COntaines_______________");
		List<Employee> list3=employeeRepository.findByNameContains("n");
		list3.forEach(e4->{System.out.println(e4);});
		System.out.println("______________JPQL_______________");
       List<Employee> list4=employeeRepository.findByRole("opp");
       list4.forEach(e5->{System.out.println(e5);});
       System.out.println("______________JPQL1_______________");
       List<Employee>list6=employeeRepository.getEmps();
       list6.forEach(e6->{System.out.println(e6);});
       System.out.println("______________JPQL2_______________");
       List<Employee> list8=employeeRepository.getAllEmployee();
       //list8.forEach(e8->{System.out.println(e8);});   
       Iterator< Employee> itr=list8.iterator();
//       while(itr.hasNext()) {
//    	   System.out.println(itr.next());
//       }
       
	}

}
