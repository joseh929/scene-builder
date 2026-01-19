package com.payroll;

import java.sql.*;
import java.time.format.DateTimeFormatter;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:payroll.db";
    
    public void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            String createTableSQL = "CREATE TABLE IF NOT EXISTS payroll (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "employee_id TEXT NOT NULL, " +
                    "name TEXT NOT NULL, " +
                    "basic_salary REAL NOT NULL, " +
                    "allowances REAL NOT NULL, " +
                    "tax_rate REAL NOT NULL, " +
                    "other_deductions REAL NOT NULL, " +
                    "net_salary REAL NOT NULL, " +
                    "date TEXT NOT NULL)";
            
            stmt.execute(createTableSQL);
            System.out.println("Database initialized successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
    
    public void saveEmployee(Employee employee) {
        String insertSQL = "INSERT INTO payroll (employee_id, name, basic_salary, allowances, " +
                          "tax_rate, other_deductions, net_salary, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            
            pstmt.setString(1, employee.getEmployeeId());
            pstmt.setString(2, employee.getName());
            pstmt.setDouble(3, employee.getBasicSalary());
            pstmt.setDouble(4, employee.getAllowances());
            pstmt.setDouble(5, employee.getTaxRate());
            pstmt.setDouble(6, employee.getOtherDeductions());
            pstmt.setDouble(7, employee.getNetSalary());
            pstmt.setString(8, employee.getDate().toString());
            
            pstmt.executeUpdate();
            System.out.println("Employee saved successfully!");
            
        } catch (SQLException e) {
            System.err.println("Error saving employee: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    public String getAllRecords() {
        StringBuilder sb = new StringBuilder();
        sb.append("===============================================================================\n");
        sb.append("                         ALL PAYROLL RECORDS                                   \n");
        sb.append("===============================================================================\n\n");
        
        String selectSQL = "SELECT * FROM payroll ORDER BY id DESC";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {
            
            if (!rs.isBeforeFirst()) {
                sb.append("No records found in the database.\n");
                return sb.toString();
            }
            
            int count = 0;
            while (rs.next()) {
                count++;
                sb.append(String.format("Record #%d\n", count));
                sb.append("-------------------------------------------------------------------------------\n");
                sb.append(String.format("Employee ID:       %s\n", rs.getString("employee_id")));
                sb.append(String.format("Name:              %s\n", rs.getString("name")));
                sb.append(String.format("Basic Salary:      KSh %,.2f\n", rs.getDouble("basic_salary")));
                sb.append(String.format("Allowances:        KSh %,.2f\n", rs.getDouble("allowances")));
                sb.append(String.format("Tax Rate:          %.1f%%\n", rs.getDouble("tax_rate")));
                sb.append(String.format("Other Deductions:  KSh %,.2f\n", rs.getDouble("other_deductions")));
                sb.append(String.format("NET SALARY:        KSh %,.2f\n", rs.getDouble("net_salary")));
                sb.append(String.format("Date:              %s\n", rs.getString("date")));
                sb.append("===============================================================================\n\n");
            }
            
            sb.append(String.format("Total Records: %d\n", count));
            
        } catch (SQLException e) {
            sb.append("Error retrieving records: ").append(e.getMessage());
        }
        
        return sb.toString();
    }
}
