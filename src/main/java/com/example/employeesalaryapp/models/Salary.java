package com.example.employeesalaryapp.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salaries")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double salary;
    private Date start_date;
    private Date end_date;
    @ManyToOne
    @JoinColumn(name = "id_employees")
    private Employee employee;

    public Salary() { }

    public Salary(double salary, Employee employee) {
        this.salary = salary;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", employee=" + employee +
                '}';
    }
}
