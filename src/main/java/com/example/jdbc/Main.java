package com.example.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/pets?" +
                "user=root&password=123456&serverTimezone=UTC");
            // 没有设置timezone 会报错
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pet")) {
            while (rs.next()) {
                // 从1开始
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
}
