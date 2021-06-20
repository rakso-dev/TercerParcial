package Entities;

public class Department {
    String dept_no;
    String dept_name;

    public Department(String dept_no, String dept_name) {
        if(!dept_no.isEmpty() || dept_no.length() <= 4)
            this.dept_no = dept_no;
        if(!dept_name.isEmpty() || dept_name.length() <= 40)
            this.dept_name = dept_name;
    }

    public Department(String dept_no) {
        if(dept_no.isEmpty() || dept_no.length() <= 4)
            this.dept_no = dept_no;
    }

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
