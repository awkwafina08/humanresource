public abstract class Staff implements ICaculator {
    private int id;
    private String name;
    private int age;
    private double coefficientsSalary;
    private String date;
    private Department workingDeparment;
    private int leaveDay;

    //Abstract method
    public abstract void displayInformation();
    public abstract void displaySalary();
    //Contructor
    public Staff(){

    }

    /**
     * Constructor
     * @param id int
     * @param name String
     * @param age int
     * @param startDate String
     * @param workingDeparment Deparment
     * @param coefficientsSalary double
     * @param leaveDay int
     */
    public Staff(int id, String name, int age, String startDate, Department workingDeparment, double coefficientsSalary, int leaveDay){
        this.id = id;
        this.name = name;
        this.age = age;
        this.date = startDate;
        this.workingDeparment = workingDeparment;
        this.leaveDay = leaveDay;
        this.coefficientsSalary = coefficientsSalary;
    }

    /**
     * Accessor method to get ID
     * @return id type int
     */
    public int getId(){
        return this.id;
    }
    /**
     * Accessor method to get name
     * @return name type String
     */
    public String getName(){
        return this.name;
    }
    /**
     * Accessor method to get age
     * @return age type int
     */
    public int getAge(){
        return this.age;
    }
    /**
     * Accessor method to get date
     * @return date type String
     */
    public String getDate(){
        return this.date;
    }
    /**
     * Accessor method to get coefficient salary
     * @return coefficient salary type double
     */
    public double getCoefficientsSalary(){
        return coefficientsSalary;
    }
    /**
     * Accessor method to get working department
     * @return workingDepartment type Department
     */
    public Department getWorkingDeparment(){
        return this.workingDeparment;
    }/**
     * Accessor method to get leave day
     * @return leave day type int
     */
    public int getLeaveDay(){
        return this.leaveDay;
    }
}
