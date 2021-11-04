import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HumanResources {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<Staff> staff = new ArrayList<>();
        ArrayList<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "Nhân sự"));
        departments.add(new Department(2, "Kinh doanh"));
        departments.add(new Department(3, "Kĩ thuật"));
        departments.add(new Department(4, "Dự án"));
        int myChoice;
        //Choose what to do follow menu
        do {
            begin();
            myChoice = sc.nextInt();
            if(myChoice == 1){
                printStaffList(staff);
            }
            if(myChoice == 2){
                printDepartmentList(departments);
            }
            if(myChoice == 3){
                printStaffDeparmentList(staff, departments);
            }
            //Add staff to list
            if(myChoice == 4){
                staff.add(addStaff(staff,departments));
            }
            if(myChoice == 5){
                search(staff);
            }
            if(myChoice == 6){
                printSalary(staff);
            }
            if(myChoice == 7){
                printSortSalary(staff);
            }
            if(myChoice == 8){
                printDecreaseSalary(staff);
            }
        } while (myChoice == 1 || myChoice == 2 || myChoice == 3 || myChoice == 4 ||
                 myChoice == 5 || myChoice == 6 || myChoice == 7 || myChoice == 8);


    }

    /**
     * Print menu
     */
    public static void begin() {
        System.out.println("--------------------------Menu-----------------------------");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("2. Hiển thị các bộ phận trong công ty.");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phân.");
        System.out.println("4. Thêm nhân viên mới vào công ty.");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.");
        System.out.println("9. Đóng.");
    }
    /**
     * Choose type of staff you want to add
     * @param staff ArrayList<Staff>
     * @return addEmployee or addManager  type Staff
     */

    public static Staff addStaff(ArrayList<Staff> staff, ArrayList<Department> departments){
        System.out.println("Chọn loại nhân viên");
        System.out.println("1. Thêm nhân viên thông thường");
        System.out.println("2. Thêm nhân viên cấp quản lý ");
        int myChoice = sc.nextInt();
        sc.nextLine();
        return switch (myChoice) {
            case 1 -> addEmployee(staff, departments);
            case 2 -> addManager(staff, departments);
            default -> addStaff(staff, departments);
        };
    }
    /**
     * @param staff ArrayList<Staff>
     * @return Employee type Staff
     */

    public static Staff  addEmployee(ArrayList<Staff> staff, ArrayList<Department> departments){
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        Department department;
        department = inputDepartment(departments);
        int id = staffID(staff);
        int age = inputStaffAge();
        String date = inputDate();
        double coefficientsSalary = inputCoefficientSalary();
        int leaveDay = inputLeaveDay();
        int overTime = inputOverTime();
        return new Employee(id, name, age, date, department, coefficientsSalary, leaveDay, overTime);
    }

    /**
     *
     * @param staff type ArrayList<Staff>
     * @param departments type ArrayList<Department>
     * @return manager type Staff
     */
    public static Staff addManager(ArrayList<Staff> staff, ArrayList<Department> departments){
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        Department department;
        department = inputDepartment(departments);

        int id = staffID(staff);
        int age = inputStaffAge();
        //System.out.print("Nhập ngày bắt đầu làm việc: ");
        String date = inputDate();

        double coefficientsSalary = inputCoefficientSalary();
        int leaveDay = inputLeaveDay();
        sc.nextLine();
        String title = inputTitle();
        return new Manager(id, name, age, date, department, coefficientsSalary, leaveDay, title);
    }

    /**
     * Choose department that staff is working at
     * @param departments type ArrayList<Deparment>
     * @return department is the department staff is working at type Department
     */
    public static Department inputDepartment(ArrayList<Department> departments){
        int choice;
        do {
            System.out.println("Chọn bộ phận");
            System.out.println("1. Bộ phận nhân sự");
            System.out.println("2. Bộ phận kinh doanh");
            System.out.println("3. Bộ phận kỹ thuật");
            System.out.println("4. Bộ phận dự án");
            choice = sc.nextInt();
        } while(choice != 1 && choice !=2 && choice != 3 && choice != 4);
        if(choice == 1){
            departments.get(0).addOneNumberOfStaff();
            return departments.get(0);
        }
        if(choice == 2){
            departments.get(1).addOneNumberOfStaff();
            return departments.get(1);
        }
        if(choice == 3){
            departments.get(2).addOneNumberOfStaff();
            return departments.get(2);
        }
        departments.get(3).addOneNumberOfStaff();
        return departments.get(3);
    }

    /**
     *
     * @param staff ArrayList<Staff>
     * @return id type int
     */
    public static int staffID(ArrayList<Staff> staff){
        System.out.print("Nhập mã nhân viên: ");
        int id = sc.nextInt();
        if(id <= 0){
            System.out.println("Mã nhân viên phải lớn hơn 0. Nhập lại!");
        }
        for(int i = 0; i < staff.size(); i++){
            int staffID = staff.get(i).getId();
            if(id == staffID){
                System.out.println("ID này đã tồn tại. Vui lòng chọn ID khác");
                return staffID(staff);
            }
        }
        return id;
    }

    /**
     * Get age form user
     * @return age type int
     */
    public static int inputStaffAge(){
        System.out.print("Nhập tuổi hiện tại của nhân viên: ");
        int age = sc.nextInt();
        if(age <= 0){
            System.out.println("Tuổi phải lớn hơn 0");
            return  inputStaffAge();
        }
        return age;

    }

    /**
     * Get coefficient salary from user
     * @return coefficientsSalary type double
     */
    public static double inputCoefficientSalary(){
        System.out.print("Nhập hệ số lương: ");
        double coefficientsSalary = sc.nextInt();
        if( coefficientsSalary < 0){
            System.out.println("Hệ số lương phải lớn hơn hoặc bằng 0");
            return inputCoefficientSalary();
        }
        return coefficientsSalary;
    }

    /**
     * Get leave day from user
     * @return leaveDay type int
     */
    public static int inputLeaveDay(){
        System.out.print("Nhập số ngày phép: ");
        int leaveDay = sc.nextInt();
        if(leaveDay < 0){
            System.out.println("Số ngày phép phải lớn hơn hoặc bằng 0");
            return  inputLeaveDay();
        }
        return leaveDay;

    }

    /**
     * Get over time from user
     * @return overTime type int
     */
    public static int inputOverTime(){
        System.out.print("Nhập số giờ làm thêm: ");
        int overTime = sc.nextInt();
        if(overTime < 0){
            System.out.println("Số giờ làm thêm phải lớn hơn hoặc bằng 0");
            return  inputOverTime();
        }
        return overTime;

    }

    /**
     * Choose Manager title
     * @return str is manager title type String
     */
    public static String inputTitle(){
        System.out.println("Chọn chức danh của nhân viên");
        System.out.println("1. Business Leader");
        System.out.println("2. Project Leader");
        System.out.println("3. Technical Leader");

        int choice = sc.nextInt();
        String str = "";
        if(choice == 1){
            str = "Business Leader";
        }
        if(choice == 2){
            str = "Project Leader";
        }
        if(choice == 3){
            str = "Technical Leader";
        }
        if(choice != 1 && choice != 2 && choice != 3){
            return inputTitle();
        }
        return str;

    }

    /**
     * Print list of staff
     * @param staff ArrayList<Staff>
     */
    public static void printStaffList(ArrayList<Staff> staff){
        print();
        for (Staff value : staff) {
            value.displayInformation();
        }
    }

    /**
     * Print list of Deparment include name of department, staff in deparment, id of department
     * @param departments ArrayList<Department>
     */
    public static void printDepartmentList(ArrayList<Department> departments){
        for (Department department : departments) {
            System.out.println(department.toString());
            System.out.println();
        }
    }

    /**
     * Print list of Staff follow department name
     * @param staff ArrayList<Staff> staff
     * @param departments ArrayList<Department>
     */
    public static void printStaffDeparmentList(ArrayList<Staff> staff, ArrayList<Department> departments){
        print();
        for (Department department : departments) {
            for (Staff value : staff) {
                if (department.equals(value.getWorkingDeparment())) {
                    value.displayInformation();
                }
            }
        }
    }

    /**
     * print header of a table
     */
    public static void print(){
        System.out.format("%-4s%-15s%-8s%-15s%-15s%-15s%-10s%-5s%-15s\n", "ID", "Tên", "Tuổi", "Hệ số lương", "Ngày vào làm", "Bộ phận", "Ngày phép", "OT", "Chức danh");
    }

    /**
     * Choose method to search (by name or id)
     * Get search key from input then return list result same as search key
     * @param staff ArrayList<Staff>
     */
    public static void search(ArrayList<Staff> staff){
        System.out.println("Chọn cách tìm kiếm");
        System.out.println("1. Tìm theo tên.");
        System.out.println("2. Tìm theo ID.");
        int choice;
        do {
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2);
        if (choice == 1){
            sc.nextLine();
            System.out.print("Nhập tên muốn tìm: ");
            String name = sc.nextLine();
            name = name.toLowerCase().trim();
            print();
            int count = 0;
            for(Staff value : staff) {
                if(value.getName().toLowerCase().trim().equals(name)){
                    value.displayInformation();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("Không có kết quả nào trùng khớp");
            }
            System.out.println();
        }
        if(choice == 2) {
            System.out.print("Nhập ID muốn tìm: ");
            int id = sc.nextInt();
            print();
            int count = 0;
            for(Staff value : staff) {
                if(value.getId() == id){
                    value.displayInformation();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("Không có kết quả nào trùng khớp");
            }
            System.out.println();
        }
    }

    /**
     * Print list of salary as a table
     * @param staff ArrayList<Staff>
     */
    public static void printSalary(ArrayList<Staff> staff){
        System.out.format("%-4s%-15s%-20s\n", "ID", "Tên", "Lương");
        for(Staff value : staff){
            value.displaySalary();
        }
    }

    /**
     * Print list of Staff's salaries sorted in ascending order
     * @param staff ArrayList<Staff>
     */
    public static void printSortSalary(ArrayList<Staff> staff){
        ArrayList<Staff> tempStaff = new ArrayList<>(staff);
        System.out.format("%-4s%-15s%-20s\n", "ID", "Tên", "Lương");
        int index = 0;
        do {
            double minSalary = tempStaff.get(0).calculateSalary();
            for (int i = 0; i < tempStaff.size(); i++) {
                if (tempStaff.get(i).calculateSalary() <= minSalary) {
                    minSalary = tempStaff.get(i).calculateSalary();
                    index = i;
                }
            }
            tempStaff.get(index).displaySalary();
            tempStaff.remove(index);
        } while (tempStaff.size() != 0);
    }

    /**
     * Input staff start working date
     * @return str is start working date type String
     */
    public static String inputDate(){
        System.out.print("Nhập ngày bắt đầu làm việc: ");
        String str = sc.next();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String returnStr;
        try {
            Date date = formatter.parse(str);
            returnStr = formatter.format(date);
            return returnStr;
        } catch (ParseException e) {
            System.out.println("Sai định dạng ngày");
            return inputDate();
        }
    }

    /**
     * Print list of Staff's salaries sorted in decreasing order
     * @param staff ArrayList<Staff>
     */
    public static void printDecreaseSalary(ArrayList<Staff> staff){
        ArrayList<Staff> tempStaff = new ArrayList<>(staff);
        System.out.format("%-4s%-15s%-20s\n", "ID", "Tên", "Lương");
        int index = 0;
        do {
            double maxSalary = tempStaff.get(0).calculateSalary();
            for (int i = 0; i < tempStaff.size(); i++) {
                if (tempStaff.get(i).calculateSalary() >= maxSalary) {
                    maxSalary = tempStaff.get(i).calculateSalary();
                    index = i;
                }
            }
            tempStaff.get(index).displaySalary();
            tempStaff.remove(index);
        } while (tempStaff.size() != 0);
    }
}















