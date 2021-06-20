package Entities;

public class FullEmployee {
    Employee data;
    Department department;
    Employee manager;
    Salary income;
    Title title;

    public Employee getData() {
        return data;
    }

    public void setData(Employee data) {
        this.data = data;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Salary getIncome() {
        return income;
    }

    public void setIncome(Salary income) {
        this.income = income;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FullEmployee{" +
                "data=" + (data.getEmp_no() + "," + data.getFirst_name() + "," + data.getLast_name()) +
                ", department=" + department.getDept_name() +
                ", manager=" + (manager.getFirst_name() + " " + manager.getLast_name() ) +
                ", income=" + ("$" + income.getSalary()) +
                ", title=" + title.getTitle() +
                '}';
    }
}
