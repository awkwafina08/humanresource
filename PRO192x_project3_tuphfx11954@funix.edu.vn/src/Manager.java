public class Manager extends Staff{
    private String title;
    //Constructor
    public Manager(){
        super();
    }
    //Constructor
    public Manager(int id, String name, int age, String startDate, Department workingDeparment, double coefficientsSalary, int leaveDay, String title){
        super(id, name, age, startDate, workingDeparment, coefficientsSalary, leaveDay);
        this.title = title;
    }
    //Accessor method to get title of Manager
    public String getTitle(){
        return this.title;
    }

    @Override
    //Print all information of Manager
    public void displayInformation() {
        System.out.format("%-4d%-15s%-8d%-15.1f%-15s%-15s%-10d%-5s%-15s\n", super.getId()
                , super.getName(), super.getAge(), super.getCoefficientsSalary(), super.getDate()
                , super.getWorkingDeparment().getDepartmentName(), super.getLeaveDay(), "none", this.getTitle());
    }

    /**
     * Get title salary
     * @return salary follow title
     */
    public double titleSalary(){
        if(this.title.equals("Business Leader")){
            return 8000000;
        }
        if(this.title.equals("Project Leader")){
            return 5000000;
        }
        if(this.title.equals("Technical Leader")){
            return 6000000;
        }
        return 0;
    }
    @Override
    //Calculate salary
    public double calculateSalary() {
        return super.getCoefficientsSalary() * 5000000 + this.titleSalary();
    }
    @Override
    //Print salary with ID and name
    public void displaySalary() {
        System.out.format("%-4d%-15s%-20.0f\n", super.getId(), super.getName(), this.calculateSalary());
    }
}
