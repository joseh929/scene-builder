package com.payroll;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelloController {
    
    // LEFT SIDE - Employee Details
    @FXML private TextField txtEmployerName;
    @FXML private TextField txtEmployeeRef;
    @FXML private TextField txtEmployeeName;
    @FXML private TextField txtEmployeeAddress;
    @FXML private TextField txtPostCode;
    @FXML private TextField txtInnerCityWeight;
    @FXML private TextField txtBasicSalary;
    @FXML private TextField txtOverTime;
    @FXML private TextField txtGrossPay;
    @FXML private TextField txtPensionablePay;
    
    // RIGHT SIDE - Pay Slip Details
    @FXML private TextField txtPayDate;
    @FXML private ComboBox<String> cmbTaxPeriod;
    @FXML private ComboBox<String> cmbTaxCode;
    @FXML private ComboBox<String> cmbNICode;
    @FXML private TextField txtNINumber;
    @FXML private TextField txtTax;
    @FXML private TextField txtPension;
    @FXML private TextField txtStudentLoan;
    @FXML private TextField txtNIPayment;
    @FXML private TextField txtTaxablePay;
    @FXML private TextField txtDeductions;
    
    // Buttons
    @FXML private Button btnNetWages;
    @FXML private Button btnPaySlip;
    @FXML private Button btnReset;
    @FXML private Button btnExit;
    
    private DatabaseManager dbManager;
    
    @FXML
    public void initialize() {
        dbManager = new DatabaseManager();
        dbManager.initializeDatabase();
        
        // Set current date
        txtPayDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        // Initialize combo boxes
        cmbTaxPeriod.getItems().addAll(
            "Week 1", "Week 2", "Week 3", "Week 4",
            "Month 1", "Month 2", "Month 3", "Month 4", "Month 5", "Month 6",
            "Month 7", "Month 8", "Month 9", "Month 10", "Month 11", "Month 12"
        );
        cmbTaxPeriod.setValue("Week 1");
        
        cmbTaxCode.getItems().addAll(
            "1257L", "BR", "D0", "D1", "NT", "0T", "K100", "K200"
        );
        cmbTaxCode.setValue("1257L");
        
        cmbNICode.getItems().addAll(
            "A", "B", "C", "H", "J", "M", "Z"
        );
        cmbNICode.setValue("A");
        
        // Set default values
        txtStudentLoan.setText("0.00");
        txtInnerCityWeight.setText("0.00");
    }
    
    @FXML
    protected void calculateNetWages() {
        try {
            // Validate inputs
            if (txtEmployeeName.getText().trim().isEmpty() || 
                txtBasicSalary.getText().trim().isEmpty()) {
                showAlert("Error", "Please fill in Employee Name and Basic Salary");
                return;
            }
            
            // Get input values
            double basicSalary = parseDouble(txtBasicSalary.getText());
            double overTime = parseDouble(txtOverTime.getText());
            double innerCityWeight = parseDouble(txtInnerCityWeight.getText());
            double studentLoan = parseDouble(txtStudentLoan.getText());
            
            // Calculate Gross Pay
            double grossPay = basicSalary + overTime + innerCityWeight;
            txtGrossPay.setText(String.format("£%.2f", grossPay));
            
            // Calculate Tax (20% basic rate on income over £12,570 annually, simplified to 15% here)
            double taxRate = 0.15;
            double taxAmount = grossPay * taxRate;
            txtTax.setText(String.format("£%.2f", taxAmount));
            
            // Calculate Pension (5% of gross pay)
            double pensionRate = 0.05;
            double pensionAmount = grossPay * pensionRate;
            txtPension.setText(String.format("£%.2f", pensionAmount));
            
            // Calculate NI Payment (12% of earnings above £242/week, simplified to 10% here)
            double niRate = 0.10;
            double niPayment = grossPay * niRate;
            txtNIPayment.setText(String.format("£%.2f", niPayment));
            
            // Calculate Pensionable Pay (Gross - Pension)
            double pensionablePay = grossPay - pensionAmount;
            txtPensionablePay.setText(String.format("£%.2f", pensionablePay));
            
            // Calculate Taxable Pay (Gross - Pension)
            double taxablePay = pensionablePay;
            txtTaxablePay.setText(String.format("£%.2f", taxablePay));
            
            // Calculate Total Deductions
            double totalDeductions = taxAmount + pensionAmount + niPayment + studentLoan;
            txtDeductions.setText(String.format("£%.2f", totalDeductions));
            
            // Calculate Net Wages
            double netWages = grossPay - totalDeductions;
            
            showAlert("Net Wages Calculated", 
                String.format("Gross Pay: £%.2f\nTotal Deductions: £%.2f\nNet Wages: £%.2f", 
                grossPay, totalDeductions, netWages));
            
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid numbers for all numeric fields");
        }
    }
    
    @FXML
    protected void generatePaySlip() {
        try {
            // Validate that calculations have been done
            if (txtGrossPay.getText().isEmpty()) {
                showAlert("Error", "Please calculate Net Wages first");
                return;
            }
            
            // Create payslip content
            StringBuilder payslip = new StringBuilder();
            payslip.append("═══════════════════════════════════════════════════════\n");
            payslip.append("                    PAY SLIP                           \n");
            payslip.append("═══════════════════════════════════════════════════════\n\n");
            payslip.append(String.format("Employer: %s\n", txtEmployerName.getText()));
            payslip.append(String.format("Employee Ref: %s\n", txtEmployeeRef.getText()));
            payslip.append(String.format("Employee Name: %s\n", txtEmployeeName.getText()));
            payslip.append(String.format("Address: %s\n", txtEmployeeAddress.getText()));
            payslip.append(String.format("Post Code: %s\n", txtPostCode.getText()));
            payslip.append(String.format("Pay Date: %s\n", txtPayDate.getText()));
            payslip.append(String.format("Tax Period: %s\n", cmbTaxPeriod.getValue()));
            payslip.append(String.format("Tax Code: %s\n", cmbTaxCode.getValue()));
            payslip.append(String.format("NI Code: %s\n", cmbNICode.getValue()));
            payslip.append(String.format("NI Number: %s\n\n", txtNINumber.getText()));
            payslip.append("───────────────────────────────────────────────────────\n");
            payslip.append("EARNINGS:\n");
            payslip.append("───────────────────────────────────────────────────────\n");
            payslip.append(String.format("Basic Salary:        %s\n", txtBasicSalary.getText()));
            payslip.append(String.format("Over Time:           %s\n", txtOverTime.getText()));
            payslip.append(String.format("Inner City Weight:   %s\n", txtInnerCityWeight.getText()));
            payslip.append(String.format("Gross Pay:           %s\n\n", txtGrossPay.getText()));
            payslip.append("───────────────────────────────────────────────────────\n");
            payslip.append("DEDUCTIONS:\n");
            payslip.append("───────────────────────────────────────────────────────\n");
            payslip.append(String.format("Tax:                 %s\n", txtTax.getText()));
            payslip.append(String.format("Pension:             %s\n", txtPension.getText()));
            payslip.append(String.format("NI Payment:          %s\n", txtNIPayment.getText()));
            payslip.append(String.format("Student Loan:        %s\n", txtStudentLoan.getText()));
            payslip.append(String.format("Total Deductions:    %s\n\n", txtDeductions.getText()));
            payslip.append("═══════════════════════════════════════════════════════\n");
            
            double gross = parseDoubleFromCurrency(txtGrossPay.getText());
            double deductions = parseDoubleFromCurrency(txtDeductions.getText());
            double netWages = gross - deductions;
            
            payslip.append(String.format("NET WAGES:           £%.2f\n", netWages));
            payslip.append("═══════════════════════════════════════════════════════\n");
            
            // Display in a new window
            Stage payslipStage = new Stage();
            payslipStage.setTitle("Pay Slip");
            
            TextArea payslipArea = new TextArea(payslip.toString());
            payslipArea.setEditable(false);
            payslipArea.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12px;");
            
            javafx.scene.Scene scene = new javafx.scene.Scene(
                new javafx.scene.layout.VBox(payslipArea), 600, 700);
            payslipStage.setScene(scene);
            payslipStage.show();
            
            // Save to database
            saveToDatabase(netWages);
            
        } catch (Exception e) {
            showAlert("Error", "Error generating pay slip: " + e.getMessage());
        }
    }
    
    private void saveToDatabase(double netWages) {
        try {
            Employee emp = new Employee(
                txtEmployeeRef.getText(),
                txtEmployeeName.getText(),
                parseDouble(txtBasicSalary.getText()),
                parseDouble(txtOverTime.getText()),
                15.0, // Tax rate
                parseDoubleFromCurrency(txtDeductions.getText()),
                netWages
            );
            
            dbManager.saveEmployee(emp);
            
        } catch (Exception e) {
            System.err.println("Error saving to database: " + e.getMessage());
        }
    }
    
    @FXML
    protected void resetForm() {
        // Clear employee details
        txtEmployerName.clear();
        txtEmployeeRef.clear();
        txtEmployeeName.clear();
        txtEmployeeAddress.clear();
        txtPostCode.clear();
        txtInnerCityWeight.setText("0.00");
        txtBasicSalary.clear();
        txtOverTime.clear();
        txtGrossPay.clear();
        txtPensionablePay.clear();
        
        // Clear pay slip details
        txtPayDate.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cmbTaxPeriod.setValue("Week 1");
        cmbTaxCode.setValue("1257L");
        cmbNICode.setValue("A");
        txtNINumber.clear();
        txtTax.clear();
        txtPension.clear();
        txtStudentLoan.setText("0.00");
        txtNIPayment.clear();
        txtTaxablePay.clear();
        txtDeductions.clear();
    }
    
    @FXML
    protected void exitApplication() {
        System.exit(0);
    }
    
    private double parseDouble(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0.0;
        }
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    private double parseDoubleFromCurrency(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0.0;
        }
        // Remove currency symbol and parse
        text = text.replace("£", "").replace(",", "").trim();
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(
            title.equals("Error") ? Alert.AlertType.ERROR : Alert.AlertType.INFORMATION
        );
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
