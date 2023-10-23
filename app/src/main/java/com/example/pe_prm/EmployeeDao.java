package com.example.pe_prm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Optional;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM Employee")
    List<Employee> getAll();

    @Query("SELECT * FROM Employee WHERE id IN (:employeeIds)")
    List<Employee> loadAllByIds(int[] employeeIds);

    @Query("SELECT * FROM Employee WHERE id = (:employeeId)")
    Optional<Employee> findEmployeeById(int employeeId);

    @Insert
    void insertAll(Employee... employees);

    @Delete
    void delete(Employee employee);

    @Query("SELECT * FROM Employee WHERE full_name LIKE (:fullName) AND hire_date = (:hireDate) AND salary <= (:salary)")
    List<Employee> findByAll(String fullName, String hireDate, double salary);

    @Query("UPDATE Employee SET full_name = (:fullName), hire_date = (:hireDate), salary = (:salary) WHERE id = (:id)")
    void update(int id,String fullName, String hireDate, double salary);

    @Query("DELETE FROM Employee WHERE id = (:id)")
    void deleteById(int id);

    @Query("SELECT * FROM Employee WHERE full_name LIKE (:fullName)")
    List<Employee> findByFullName(String fullName);

    @Query("SELECT * FROM Employee WHERE hire_date = (:hireDate)")
    List<Employee> findByHireDate(String hireDate);

    @Query("SELECT * FROM Employee WHERE salary <= (:salary)")
    List<Employee> findBySalary(double salary);

    @Query("SELECT * FROM Employee WHERE full_name LIKE (:fullName) AND hire_date = (:hireDate)")
    List<Employee> findByFullNameAndHireDate(String fullName, String hireDate);

    @Query("SELECT * FROM Employee WHERE full_name LIKE (:fullName) AND salary <= (:salary)")
    List<Employee> findByFullNameAndSalary(String fullName, double salary);

    @Query("SELECT * FROM Employee WHERE hire_date = (:hireDate) AND salary <= (:salary)")
    List<Employee> findByHireDateAndSalary(String hireDate, double salary);
}