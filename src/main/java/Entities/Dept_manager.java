package Entities;

import java.sql.Date;

public class Dept_manager {
    int emp_no;
    String dept_no; //      CHAR(4)         NOT NULL,
    Date from_date; //    DATE            NOT NULL,
    Date to_date; //      DATE            NOT NULL,

    public Dept_manager(int emp_no, String dept_no, Date from_date, Date to_date) {
        if(emp_no > 0)
            this.emp_no = emp_no;
        if(!dept_no.isEmpty() || dept_no.length() <= 4)
            this.dept_no = dept_no;
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

    public String getDept_no() {
        return dept_no;
    }

    public void setDept_no(String dept_no) {
        this.dept_no = dept_no;
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
