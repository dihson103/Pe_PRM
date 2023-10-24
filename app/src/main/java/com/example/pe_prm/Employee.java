package com.example.pe_prm;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Employee {
        @PrimaryKey(autoGenerate = true)
        public int id;

        @ColumnInfo(name = "full_name")
        public String fullName;

        @ColumnInfo(name = "hire_date")
        public String hireDate;

        @ColumnInfo(name = "salary")
        public double salary;

    public Employee( String fullName, String hireDate, double salary) {
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee(String fullName, String hireDate, String salary) {
            setFullName(fullName);
            setHireDate(hireDate);
            setSalary(salary);
        }


    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            if(fullName.isEmpty() || fullName == null)
                throw new IllegalArgumentException("Full name is empty");
            this.fullName = fullName;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            if(hireDate.isEmpty() || hireDate == null){
                SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                this.hireDate = sf.format(new Date());
            }else {
                this.hireDate = hireDate;
            }
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(String salary) {

            try {
                this.salary = Double.parseDouble(salary);
            }
            catch (Exception e){
                throw new IllegalArgumentException("Salary is not a number");
            }
        }
}