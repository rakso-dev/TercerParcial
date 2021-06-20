package Entities;

import java.sql.Date;

public class Salary {
    int emp_no; //      INT             NOT NULL,
    int salary; //      INT             NOT NULL,
    Date from_date; //   DATE            NOT NULL,
    Date to_date; //     DATE            NOT NULL,

    public Salary(int emp_no, int salary, Date from_date, Date to_date) {
        if(emp_no > 0)
            this.emp_no = emp_no;
        if(salary > 0)
            this.salary = salary;
        if(from_date != null)
            this.from_date = from_date;
        if(to_date != null)
            this.to_date = to_date;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }
}
