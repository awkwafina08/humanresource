public class Department {
    private int id;
    private String departmentName;
    private int numberOfStaff = 0;
    //Constructor
    public Department(int id, String name){
        this.id = id;
        this.departmentName = name;

    }
    //Constructor
    public Department() {
    }
    //Accessor method to get id
    public int getId(){
        return this.id;
    }
    //Accessor method to get Department name
    public String getDepartmentName(){
        return this.departmentName;
    }
    //Accessor method to get number of staff in this Department
    public int getNumberOfStaff(){
        return this.numberOfStaff;
    }
    //Mutator method to add one more staff in this Department
    public void addOneNumberOfStaff(){
        this.numberOfStaff++;
    }

    /**
     * Check that two department equals or npt
     * @param department Department
     * @return true if equals false if not
     */
    public boolean equals(Department department){
        return department.getId() == this.id;
    }

    /**
     * Convert the information of Department to String
     * @return all information of Department as String str
     */
    public String toString(){
        String str = "Mã bộ phận: " + this.id +
                    ".\nTên bộ phận: " + this.departmentName +
                    ".\nSố lượng nhân viên: "+ this.numberOfStaff;
        return str;
    }
}
