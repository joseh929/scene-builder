# Payroll Management System (JavaFX)

## Description
A complete JavaFX-based Payroll Management System that allows users to:
- Capture employee details (ID, Name, Salary, Allowances)
- Calculate salaries with automatic tax and deduction calculations
- Generate professional payslips
- Store all payroll data in an SQLite database
- View all historical payroll records

## Technologies Used
- **Java 11+**
- **JavaFX 17** - For the graphical user interface
- **SQLite** - Lightweight database for data storage
- **Maven** - Build and dependency management
- **IntelliJ IDEA** - Recommended IDE

## Features
1. **Employee Data Entry** - Easy form to input employee information
2. **Automatic Calculations** - Computes gross salary, tax, deductions, and net salary
3. **Payslip Generation** - Professional formatted payslips with all earnings and deductions
4. **Database Storage** - Persistent storage using SQLite database
5. **View Records** - View all saved payroll records in a separate window
6. **User-Friendly Interface** - Clean, intuitive design with color-coded buttons

## Project Structure
```
PayrollSystem/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   ├── Launcher.java
│       │   ├── module-info.java
│       │   └── com/
│       │       └── payroll/
│       │           ├── MainApp.java
│       │           ├── Employee.java
│       │           └── DatabaseManager.java
│       └── resources/
└── payroll.db (created automatically)
```

## Setup Instructions

### Prerequisites
1. **Java JDK 11 or higher** - [Download here](https://www.oracle.com/java/technologies/downloads/)
2. **IntelliJ IDEA** - [Download here](https://www.jetbrains.com/idea/download/)
3. **Maven** (usually comes with IntelliJ)

### Installation Steps

#### Method 1: Using IntelliJ IDEA (RECOMMENDED)

1. **Open IntelliJ IDEA**

2. **Import the Project:**
   - Click `File` → `Open`
   - Navigate to the `PayrollSystem` folder
   - Select the folder and click `OK`
   - IntelliJ will detect it's a Maven project and import it

3. **Wait for Maven to Download Dependencies:**
   - Look at the bottom right of IntelliJ
   - Wait for "Indexing..." and "Downloading..." to complete
   - This downloads JavaFX and SQLite libraries

4. **Configure JavaFX (if needed):**
   - IntelliJ usually handles this automatically with Maven
   - If you get errors, go to `File` → `Project Structure` → `Libraries`
   - Make sure JavaFX libraries are listed

5. **Run the Application:**
   - Find `Launcher.java` in the Project panel
   - Right-click on it
   - Select `Run 'Launcher.main()'`
   - The application window should open!

#### Method 2: Using Command Line with Maven

```bash
# Navigate to project directory
cd PayrollSystem

# Clean and compile
mvn clean compile

# Run the application
mvn javafx:run
```

## How to Use

### 1. Starting the Application
- Run `Launcher.java` from IntelliJ
- The main window will open with the title "PAYROLL MANAGEMENT SYSTEM"

### 2. Entering Employee Data
Fill in the form fields:
- **Employee ID**: Unique identifier (e.g., "EMP001")
- **Employee Name**: Full name of the employee
- **Basic Salary**: Base salary amount (e.g., 50000)
- **Allowances**: Additional allowances (e.g., 5000) - defaults to 0
- **Tax Rate (%)**: Percentage of tax (e.g., 15) - defaults to 15%
- **Other Deductions**: Any other deductions (e.g., 2000) - defaults to 0

### 3. Calculate Salary
- Click the **"Calculate Salary"** button (Green)
- The system will:
  - Calculate Gross Salary = Basic Salary + Allowances
  - Calculate Tax Amount = Gross Salary × Tax Rate%
  - Calculate Total Deductions = Tax Amount + Other Deductions
  - Calculate Net Salary = Gross Salary - Total Deductions
- A formatted payslip will appear in the preview area below

### 4. Save to Database
- After calculating, click **"Save to Database"** button (Blue)
- The employee payroll data will be saved to the SQLite database
- A success message will appear

### 5. View All Records
- Click **"View All Records"** button (Purple)
- A new window opens showing all saved payroll records
- Records are displayed in reverse chronological order (newest first)

### 6. Clear Form
- Click **"Clear Form"** button (Orange)
- Clears all input fields and payslip preview
- Ready for next employee entry

## Example Usage

### Sample Employee Entry:
```
Employee ID: EMP001
Employee Name: John Doe
Basic Salary: 50000
Allowances: 5000
Tax Rate (%): 15
Other Deductions: 2000
```

### Resulting Calculation:
```
Gross Salary: 55,000
Tax (15%): 8,250
Other Deductions: 2,000
Total Deductions: 10,250
NET SALARY: 44,750
```

## Troubleshooting

### Problem: "JavaFX runtime components are missing"
**Solution:**
- Make sure Maven has downloaded dependencies
- In IntelliJ: Right-click `pom.xml` → Maven → Reload Project
- Check that `javafx-controls` and `javafx-fxml` appear in External Libraries

### Problem: Application won't start
**Solution:**
- Make sure you're running Java 11 or higher
- Check `File` → `Project Structure` → `Project` → SDK is set to Java 11+
- Try `Build` → `Rebuild Project`

### Problem: Database errors
**Solution:**
- The `payroll.db` file is created automatically
- Make sure you have write permissions in the project folder
- Delete `payroll.db` if corrupted and restart the app

### Problem: Numbers not calculating
**Solution:**
- Make sure you enter valid numbers (no commas or special characters)
- Use decimal point for cents (e.g., 50000.50)
- All numeric fields must be filled

## Database Schema

The SQLite database (`payroll.db`) has one table:

```sql
CREATE TABLE payroll (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    employee_id TEXT NOT NULL,
    name TEXT NOT NULL,
    basic_salary REAL NOT NULL,
    allowances REAL NOT NULL,
    tax_rate REAL NOT NULL,
    other_deductions REAL NOT NULL,
    net_salary REAL NOT NULL,
    date TEXT NOT NULL
);
```

## Future Enhancements (Optional)
- Export payslips to PDF
- Email payslips to employees
- Search and filter records
- Edit existing records
- Multiple tax brackets
- Monthly/Annual reports
- User authentication

## Notes for Submission
- All source code is included
- Database is created automatically on first run
- No external database server required
- Application is fully functional and tested
- Clean, commented code following best practices

## Credits
Created for Payroll Management System Project
Developed using JavaFX and SQLite

## License
Educational/Academic Use

---

**Good luck with your submission! 🚀**
