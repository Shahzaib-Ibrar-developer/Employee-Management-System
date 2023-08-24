// Employee management system using JDBC  
// Frontened page of our project
package com.student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.student.manage.EmployeeDao;
import com.student.manage.Manage;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WellCome to Employee Management System");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("1: Add the Employee ");
            System.out.println("2: Delete the Employee");
            System.out.println("3: ALL Employee Data");
            System.out.println("4: Update the Employee");
            System.out.println("5: Exit");

            System.out.println("Enter your Choice ");
            int selectNumber = Integer.parseInt(br.readLine());
            // logic cases

            if (selectNumber == 1) {
                // add the employee

                System.out.println("Enter Name ");
                String n = br.readLine();
                System.out.println("Enter Designation ");
                String d = br.readLine();
                System.out.println("Enter Phone ");
                String p = br.readLine();
                System.out.println("Enter Salary  ");
                String s = br.readLine();
                Manage mt = new Manage(n, d, p, s);
                Boolean answer = EmployeeDao.addEmployee(mt);
                if (answer) {
                    System.out.println("Added sucessfully");
                } else {
                    System.out.println("Some thing went wrong .. ..");
                }
                System.out.println(mt);
            } else if (selectNumber == 2) {
                // delete the employee
                System.out.println("Enter the employee ID to delete:");
                int employeeIdToDelete = scanner.nextInt();
                Boolean answer = EmployeeDao.deleteEmployee(employeeIdToDelete);
                if (answer) {
                    System.out.println("Deleted sucessfully");
                } else {
                    System.out.println("Some thing went wrong .. ..");
                }
            } else if (selectNumber == 3) {
                // Show all employees
                EmployeeDao.showAllEmployee();
            }
            
            else if (selectNumber == 4) {
                // update existing employee
                System.out.print("Enter the ID of the employee to update: ");
                int employeeIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                EmployeeDao.updateEmployee(employeeIdToUpdate);
            } else if (selectNumber == 5) {
                break;
            } else {

            }

        }
        System.out.println("Thankyou for using Our Application");
        System.out.println("Have a Good day bye .... bye ....");
    }
}
