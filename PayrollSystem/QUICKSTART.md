# QUICK START GUIDE - READ THIS FIRST!

## 🚨 FASTEST WAY TO GET RUNNING 🚨

### Step 1: Open IntelliJ IDEA
- Double-click IntelliJ IDEA icon on your desktop

### Step 2: Open This Project
- Click `File` → `Open`
- Find the `PayrollSystem` folder
- Click `Open`
- Wait 1-2 minutes for IntelliJ to load everything

### Step 3: Let Maven Download Stuff
- Look at the bottom-right corner of IntelliJ
- You'll see "Downloading..." or "Indexing..."
- **WAIT until this finishes** (2-5 minutes)
- This downloads JavaFX and database libraries

### Step 4: Run It!
- On the left side, expand folders: `src` → `main` → `java`
- Find `Launcher.java`
- Right-click on `Launcher.java`
- Click `Run 'Launcher.main()'`
- **DONE!** The window should pop up!

## If It Doesn't Work:

### Fix 1: Reload Maven
- Right-click on `pom.xml` (in the project root)
- Click `Maven` → `Reload Project`
- Wait for it to finish
- Try running again

### Fix 2: Rebuild
- Click `Build` menu at top
- Click `Rebuild Project`
- Wait for it to finish
- Try running again

### Fix 3: Check Java Version
- Click `File` → `Project Structure`
- Click `Project` on the left
- Make sure SDK is Java 11 or higher
- If not, download Java 17 and set it here

## How to Test It Works:

1. **Enter sample data:**
   - Employee ID: TEST001
   - Name: Test Employee
   - Basic Salary: 50000
   - Leave other fields as default

2. **Click "Calculate Salary" (green button)**
   - Should show a payslip below

3. **Click "Save to Database" (blue button)**
   - Should say "Success"

4. **Click "View All Records" (purple button)**
   - Should open a window showing your test record

**YOU'RE READY TO GO!** 🎉

## What Each Button Does:

- **Calculate Salary (Green)**: Does the math and shows payslip
- **Save to Database (Blue)**: Saves the data permanently
- **Clear Form (Orange)**: Erases everything to start fresh
- **View All Records (Purple)**: Shows all saved employees

## Tips for Your Demo:

1. **Prepare 2-3 sample employees** before your deadline
2. **Save them to database** so you have data to show
3. **Practice clicking through** the buttons
4. **Show the "View All Records"** - it looks impressive!

## What to Say During Demo:

"This payroll system allows us to:
1. Enter employee details and salary information
2. Automatically calculate taxes and deductions
3. Generate professional payslips
4. Store all data in a database
5. View all historical records"

Then just demonstrate each feature!

---

**IMPORTANT FILES TO UNDERSTAND:**

- `Launcher.java` - Starts the program (this is what you run)
- `MainApp.java` - Main window and all the buttons
- `Employee.java` - Stores employee information
- `DatabaseManager.java` - Saves/loads from database
- `pom.xml` - Maven configuration (downloads libraries)

**YOU DON'T NEED TO UNDERSTAND THE CODE FULLY - JUST KNOW WHAT IT DOES!**

Good luck! 🍀
