package Entities;

import java.sql.Date;

public class Employee {
    int emp_no;
    Date birth_date;
    String first_name;
    String last_name;
    char gender;
    Date hire_date;

    public Employee(int emp_no, Date birth_date, String first_name, String last_name, char gender, Date hire_date) {
        if(emp_no > 0)
            this.emp_no = emp_no;
        if(birth_date != null)
            this.birth_date = birth_date;
        if(first_name != null || first_name.length() <= 14)
            this.first_name = first_name;
        if(last_name != null || first_name.length() <= 16)
            this.last_name = last_name;
        if(gender == 'M' || gender == 'F')
            this.gender = gender;
        if(hire_date != null)
            this.hire_date = hire_date;
    }

    public Employee (int emp_no) {
        this.emp_no = emp_no;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }


}
