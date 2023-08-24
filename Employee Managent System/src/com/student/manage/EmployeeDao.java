package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// logic for all implementation
public class EmployeeDao {
    static Scanner scanner = new Scanner(System.in);
    static Connection con;
    static Boolean f = false;

    public static Boolean addEmployee(Manage mt) {

        try {

            con = CP.createC();
            String q = "INSERT INTO employee (name, designation, phone, salary) VALUES (?, ?, ?, ?)";
            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, mt.getId());
            pstmt.setString(1, mt.getName());
            pstmt.setString(2, mt.getDesignation());
            pstmt.setString(3, mt.getPhone());
            pstmt.setString(4, mt.getSalary());
            pstmt.executeUpdate();
            f = true;
        } catch (Exception e) {
            // Handle the exception properly, and don't use the same name for exception
            // variable
            e.printStackTrace();
        }
        return f;
    }

    public static Boolean deleteEmployee(int id) {

        try {

            con = CP.createC();
            String q = "DELETE FROM employee WHERE id = ?";
            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                f = true;
            }

        } catch (Exception e) {
            // Handle the exception properly, and don't use the same name for exception
            // variable
            e.printStackTrace();
        }
        return f;
    }

    public static Boolean showAllEmployee() {

        try {

            con = CP.createC();
            String q = "Select * from employee;";
            // prepared statement
            PreparedStatement pstmt = con.prepareStatement(q);

         ResultSet resultSet = pstmt.executeQuery();
         while (resultSet.next()) {
            int id  = resultSet.getInt("id");
            String name  = resultSet.getString("name");
            String designation = resultSet.getString("designation");
            String phone = resultSet.getString("phone");
            String salary = resultSet.getString("salary");
            System.out.println("ID: " + id + ", Name: " + name + ", Designation: " + designation
            + ", Phone: " + phone + ", Salary: " + salary);
         }
            f = true;

        } catch (Exception e) {
            // Handle the exception properly, and don't use the same name for exception
            // variable
            e.printStackTrace();
        }
        return f;
    }

     public static void updateEmployee(int employeeId) {

        try {

            con = CP.createC();
         
            // Get new salary from the user
            System.out.print("Enter the new salary: ");
            String newSalary = scanner.nextLine();

            // Get new designation from the user
            System.out.print("Enter the new designation: ");
            String newDesignation = scanner.nextLine();

            // Construct the UPDATE query
            String updateQuery = "UPDATE employee SET salary = ?, designation = ? WHERE id = ?";
            PreparedStatement pstmt = con.prepareStatement(updateQuery);

            // Set the new values for salary and designation
            pstmt.setString(1, newSalary);
            pstmt.setString(2, newDesignation);

            // Set the employee ID for the WHERE clause condition
            pstmt.setInt(3, employeeId);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " rows updated.");
 

        } catch (Exception e) {
            // Handle the exception properly, and don't use the same name for exception
            // variable
            e.printStackTrace();
        }
    
    }
}
