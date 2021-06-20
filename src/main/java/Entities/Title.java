package Entities;

import java.sql.Date;

public class Title {
    int emp_no; //      INT             NOT NULL,
    String title; //       VARCHAR(50)     NOT NULL,
    Date from_date; //   DATE            NOT NULL,
    Date to_date; //     DATE,

    public Title(int emp_no, String title, Date from_date, Date to_date) {
        if(emp_no > 0)
            this.emp_no = emp_no;
        if(!title.isEmpty() || title.length() <= 50)
            this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
