package com.payroll;

import java.time.LocalDate;

public class Employee {
    private String employeeId;
    private String name;
    private double basicSalary;
    private double allowances;
    private double taxRate;
    private double otherDeductions;
    private double netSalary;
    private LocalDate date;
    
    public Employee(String employeeId, String name, double basicSalary, 
                   double allowances, double taxRate, double otherDeductions, double netSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.taxRate = taxRate;
        this.otherDeductions = otherDeductions;
        this.netSalary = netSalary;
        this.date = LocalDate.now();
    }
    
    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBasicSalary() { return basicSalary; }
    public double getAllowances() { return allowances; }
    public double getTaxRate() { return taxRate; }
    public double getOtherDeductions() { return otherDeductions; }
    public double getNetSalary() { return netSalary; }
    public LocalDate getDate() { return date; }
    
    // Setters
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setName(String name) { this.name = name; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }
    public void setAllowances(double allowances) { this.allowances = allowances; }
    public void setTaxRate(double taxRate) { this.taxRate = taxRate; }
    public void setOtherDeductions(double otherDeductions) { this.otherDeductions = otherDeductions; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }
    public void setDate(LocalDate date) { this.date = date; }
}
