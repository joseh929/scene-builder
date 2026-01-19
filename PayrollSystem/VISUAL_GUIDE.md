# WHAT YOUR APP LOOKS LIKE - VISUAL GUIDE

## Main Window Layout

```
╔══════════════════════════════════════════════════════════════╗
║                 PAYROLL MANAGEMENT SYSTEM                     ║
╠══════════════════════════════════════════════════════════════╣
║                                                               ║
║  Employee ID:         [__________________]                   ║
║                                                               ║
║  Employee Name:       [__________________]                   ║
║                                                               ║
║  Basic Salary:        [__________________] (e.g., 50000)     ║
║                                                               ║
║  Allowances:          [__________________] (defaults: 0)     ║
║                                                               ║
║  Tax Rate (%):        [__________________] (defaults: 15)    ║
║                                                               ║
║  Other Deductions:    [__________________] (defaults: 0)     ║
║                                                               ║
╠══════════════════════════════════════════════════════════════╣
║                                                               ║
║  [Calculate Salary] [Save to Database] [Clear Form]          ║
║       (GREEN)            (BLUE)          (ORANGE)            ║
║                  [View All Records]                          ║
║                      (PURPLE)                                ║
║                                                               ║
╠══════════════════════════════════════════════════════════════╣
║  Payslip Preview:                                            ║
║  ┌────────────────────────────────────────────────────────┐ ║
║  │ ================================================        │ ║
║  │              PAYSLIP                                    │ ║
║  │ ================================================        │ ║
║  │ Date: 13/01/2026                                       │ ║
║  │ Employee ID: EMP001                                    │ ║
║  │ Employee Name: John Doe                                │ ║
║  │                                                        │ ║
║  │ EARNINGS:                                              │ ║
║  │ ------------------------------------------------        │ ║
║  │ Basic Salary:        KSh 50,000.00                     │ ║
║  │ Allowances:          KSh 5,000.00                      │ ║
║  │ ------------------------------------------------        │ ║
║  │ Gross Salary:        KSh 55,000.00                     │ ║
║  │                                                        │ ║
║  │ DEDUCTIONS:                                            │ ║
║  │ ------------------------------------------------        │ ║
║  │ Tax (15.0%):         KSh 8,250.00                      │ ║
║  │ Other Deductions:    KSh 2,000.00                      │ ║
║  │ ------------------------------------------------        │ ║
║  │ Total Deductions:    KSh 10,250.00                     │ ║
║  │                                                        │ ║
║  │ ================================================        │ ║
║  │ NET SALARY:          KSh 44,750.00                     │ ║
║  │ ================================================        │ ║
║  └────────────────────────────────────────────────────────┘ ║
╚══════════════════════════════════════════════════════════════╝
```

## Step-by-Step Visual Flow

### STEP 1: Empty Form (When You Start)
```
Employee ID:         [                    ]  ← Type here
Employee Name:       [                    ]
Basic Salary:        [                    ]
Allowances:          [         0          ]  ← Default value
Tax Rate (%):        [        15          ]  ← Default value
Other Deductions:    [         0          ]  ← Default value

Payslip Preview: (empty)
```

### STEP 2: After Filling Form
```
Employee ID:         [ EMP001             ]  ✓
Employee Name:       [ John Doe           ]  ✓
Basic Salary:        [ 50000              ]  ✓
Allowances:          [ 5000               ]  ✓
Tax Rate (%):        [ 15                 ]  ✓
Other Deductions:    [ 2000               ]  ✓
```

### STEP 3: After Clicking "Calculate Salary"
```
✓ Success alert appears
✓ Payslip shows in preview area (see example above)
✓ All calculations done automatically
```

### STEP 4: After Clicking "Save to Database"
```
✓ "Employee payroll saved to database!" message
✓ Data is now permanently stored
```

### STEP 5: After Clicking "View All Records"
```
New window opens:

╔══════════════════════════════════════════════════════════════╗
║              ALL PAYROLL RECORDS                              ║
╠══════════════════════════════════════════════════════════════╣
║                                                               ║
║  Record #1                                                    ║
║  ─────────────────────────────────────────────────────────   ║
║  Employee ID:       EMP001                                    ║
║  Name:              John Doe                                  ║
║  Basic Salary:      KSh 50,000.00                            ║
║  Allowances:        KSh 5,000.00                             ║
║  Tax Rate:          15.0%                                     ║
║  Other Deductions:  KSh 2,000.00                             ║
║  NET SALARY:        KSh 44,750.00                            ║
║  Date:              2026-01-13                               ║
║  ═════════════════════════════════════════════════════════   ║
║                                                               ║
║  Record #2                                                    ║
║  ─────────────────────────────────────────────────────────   ║
║  (Next employee...)                                           ║
║                                                               ║
║  Total Records: 2                                            ║
╚══════════════════════════════════════════════════════════════╝
```

## What Happens When You Click Each Button

### 🟢 Calculate Salary (Green Button)
**Before clicking:**
- Form has data but no payslip shown

**After clicking:**
- ✓ System calculates everything
- ✓ Payslip appears in preview area
- ✓ Shows formatted breakdown of salary
- ✓ Success message pops up

**What it calculates:**
1. Gross Salary = Basic + Allowances
2. Tax Amount = Gross × Tax Rate%
3. Total Deductions = Tax + Other Deductions
4. Net Salary = Gross - Deductions

### 🔵 Save to Database (Blue Button)
**Before clicking:**
- Data is only in memory (will be lost if you close app)

**After clicking:**
- ✓ Data saved to database file (payroll.db)
- ✓ Success message appears
- ✓ Data persists even after closing app

### 🟠 Clear Form (Orange Button)
**Before clicking:**
- Form has data and maybe a payslip

**After clicking:**
- ✓ All fields cleared
- ✓ Payslip preview cleared
- ✓ Ready for next employee

### 🟣 View All Records (Purple Button)
**Before clicking:**
- Main window showing current form

**After clicking:**
- ✓ New window opens
- ✓ Shows ALL saved employees
- ✓ Newest records appear first
- ✓ Shows total count

## Color Meanings

- **GREEN** = Action (Calculate)
- **BLUE** = Save/Store
- **ORANGE** = Reset/Clear
- **PURPLE** = View/Display

## Expected Behavior

### ✅ CORRECT - Everything Works:
1. Fill form → Click Calculate → Payslip appears
2. Click Save → Success message
3. Click View Records → All data shows
4. Click Clear → Form empties

### ❌ ERROR Messages You Might See:

**"Please fill in Employee ID and Name"**
- Cause: You forgot to fill mandatory fields
- Fix: Fill in Employee ID and Name

**"Please enter valid numbers for all numeric fields"**
- Cause: You typed letters in number fields
- Fix: Use only numbers (no commas, no letters)

**"Failed to save to database"**
- Cause: Database file issue
- Fix: Usually doesn't happen, but restart app if it does

## Demo Script (What to Say & Do)

### 1. Opening Statement:
"This is our Payroll Management System built with JavaFX. Let me demonstrate its features."

### 2. Feature 1 - Data Entry:
**SAY:** "First, we can enter employee details."
**DO:** Fill in the form with sample data

### 3. Feature 2 - Calculation:
**SAY:** "The system automatically calculates gross salary, tax, deductions, and net salary."
**DO:** Click "Calculate Salary", show the payslip

### 4. Feature 3 - Database Storage:
**SAY:** "We can save this data permanently to a database."
**DO:** Click "Save to Database", show success message

### 5. Feature 4 - View Records:
**SAY:** "And we can view all historical payroll records."
**DO:** Click "View All Records", show the records window

### 6. Feature 5 - Clear Form:
**SAY:** "The system allows us to easily clear the form for the next employee."
**DO:** Click "Clear Form"

### 7. Closing:
"This system meets all requirements: employee data capture, salary calculations, payslip generation, and database storage."

## Tips for Success

1. **Practice the demo 3 times** before presenting
2. **Prepare 2-3 test employees** in advance
3. **Know what each button does** (see above)
4. **Have the app running** before you start presenting
5. **If something goes wrong**: Close and restart the app

## Sample Test Data to Use

### Employee 1:
- ID: EMP001
- Name: Alice Johnson
- Basic: 60000
- Allowances: 7000
- Tax Rate: 15
- Deductions: 3000

### Employee 2:
- ID: EMP002
- Name: Bob Smith
- Basic: 45000
- Allowances: 4000
- Tax Rate: 12
- Deductions: 1500

### Employee 3:
- ID: EMP003
- Name: Carol Williams
- Basic: 80000
- Allowances: 10000
- Tax Rate: 18
- Deductions: 5000

---

**YOU'VE GOT THIS! The app is professional and fully functional!** 🎯
