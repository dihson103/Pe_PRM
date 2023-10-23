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
}