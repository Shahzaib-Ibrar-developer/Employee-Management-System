package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    // 5 steps to create connection
    static Connection con;

    public static Connection createC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "$Shah12345";
            String url = "jdbc:mysql://localhost:3306/employee_data";
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

