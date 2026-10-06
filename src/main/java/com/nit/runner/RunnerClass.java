package com.nit.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.beans.Employee;
import com.nit.service.EmpService;
@Component
public class RunnerClass implements CommandLineRunner {
	@Autowired
    private EmpService empService;
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		
		boolean is2 = true;
		
		while(is2) {
		System.out.println("Enter your option "
				+ "\n1.add Single employee"
				+ "\n2.add multiple employee"
				+ "\n3.view Employee"
				+ "\n4.view allEmployee"
				+ "\n5.cheak employee Exits or not"
				+ "\n6.count total Employee"
				+ "\n7.update Employee details"
				+ "\n8.Delate Employee byID"
				+ "\n9.Delete Empoyee byObject"
				+ "\n10.Delete Multiple Employees"
				+ "\n11.Delete All employees"
				+ "\n12.exit");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("_______________________ 1.add Single employee You selected___________________");
			Employee emp =new Employee();
			System.out.println("Enter name");
			String name=sc.next();
			emp.setName(name);
			System.out.println("Enter price");
			double price =sc.nextDouble();
			emp.setSal(price);
			System.out.println("Enter job");
			String job= sc.next();
			emp.setJob(job);
			String message =empService.addEmployee(emp);
			System.out.println(message);
			break;
		}
	     case 2:{
	    	 boolean is= true;
	    	 List<Employee> list = new ArrayList<Employee>();
				while(is) {
					System.out.println("_______________________ 1.add multiple employee You selected___________________");
					Employee emp =new Employee();
					System.out.println("Enter name");
					String name=sc.next();
					emp.setName(name);
					System.out.println("Enter price");
					double price =sc.nextDouble();
					emp.setSal(price);
					System.out.println("Enter job");
					String job= sc.next();
					emp.setJob(job);	
					list.add(emp);
					System.out.println("Do you want add or not (yes/no)");
					String s=sc.next();
					if(s.equals("no")) {
						is=false;
					}
				}
				System.out.println(empService.addMultipleEmp(list)+"\n all employees are saved");
				break;
			}
	     case 3:{
	    	 System.out.println("_______________________3.view Employee You selected_______________________");
	    	 System.out.println("Enter Id");
	    	 int id = sc.nextInt();
	    	 System.out.println(empService.viewEmployee(id)+"\n emp is updated");
	    	 break;
	     }
	     case 4:{
	    	 System.out.println("__________________________4.viewAll You selected_________________________");
	    	 System.out.println(empService.viewAllEmp());
	    	 break;
	     }
	     case 5:{
	    	 System.out.println("________________________5.cheak is Available or not_________________________");
	    	 System.out.println("Enter Id");
	    	 int id = sc.nextInt();
	    	 System.out.println(empService.cheakEmp(id));
	    	 break;
	     }
	     case 6:{
	    	 System.out.println(" __________________________6.total Num of Emp You selected___________________");
	    	 System.out.println("Total num of emp :"+empService.countEmp());
	    	 break;
	     }
	     case 7:{
	    	 System.out.println("_______________________ 7.Update employee You selected___________________");
				Employee emp =new Employee();
				System.out.println("Enter Id");
		    	 int id = sc.nextInt();
		    	 emp.setId(id);
				System.out.println("Enter name");
				String name=sc.next();
				emp.setName(name);
				System.out.println("Enter price");
				double price =sc.nextDouble();
				emp.setSal(price);
				System.out.println("Enter job");
				String job= sc.next();
				emp.setJob(job);
				Employee e =empService.updateEmp(emp);
				System.out.println(e);
				break;
	     }
	     case 8:{
	    	 System.out.println("Enter Id");
	    	 int id = sc.nextInt();
	    	 System.out.println(empService.deletebyId(id));
	    	 break;
	     }
	     case 9:{
	    	 
	    	 break;
	     }
	     case 10:{
	    	 List<Integer> list= new ArrayList<>();
	    	 boolean is3=true;
	    	 while(is3) {
	    		 System.out.println("Enter Id");
		    	 int id = sc.nextInt();
		    	 list.add(id);
		    	 System.out.println("Do you want yes / no");
		    	 String i=sc.next();
		    	 if(i.equals("no")) {
		    		 is3=false;
		    	 }
	    	 }
	    	 System.out.println(empService.deleteAllIds(list));
	    	 
	    	 
	    	 break;
	     }
	     case 11:{
	    	 System.out.println(empService.deleteAll());
	     }
	     case 12:{
	    	 is2=false;
	    	 break;
	     }
		default:
			System.out.println("Unexpected value: " + choice);
		}
		
		
	}
		
	}

}
