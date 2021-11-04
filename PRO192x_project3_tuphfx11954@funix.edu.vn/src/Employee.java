public class Employee extends Staff{
    private int overTime;
    //Constructor
    public Employee(){
        super();
    }
    //Constructor
    public Employee(int id, String name, int age, String startDate, Department workingDeparment, double coefficientsSalary, int leaveDay, int overTime){
        super(id, name, age, startDate, workingDeparment, coefficientsSalary, leaveDay);
        this.overTime = overTime;
    }
    @Override
    public void displayInformation() {
        System.out.format("%-4d%-15s%-8d%-15.1f%-15s%-15s%-10d%-5d%-15s\n", super.getId()
                , super.getName(), super.getAge(), super.getCoefficientsSalary(), super.getDate()
                , super.getWorkingDeparment().getDepartmentName(), super.getLeaveDay(), this.getOverTime(), "none");
    }
    /**
     * Accessor method to get over time
     * @return overTime type int
     */
    public int getOverTime(){
        return this.overTime;
    }
    @Override
    //Calculate salary
    public double calculateSalary() {
        return super.getCoefficientsSalary() * 3000000 + this.overTime * 200000;
    }
    @Override
    //Print salary with name and ID
    public void displaySalary() {
        System.out.format("%-4d%-15s%-20.0f\n", super.getId(), super.getName(), this.calculateSalary());
    }
}
