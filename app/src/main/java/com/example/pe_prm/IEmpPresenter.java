package com.example.pe_prm;

import java.util.List;

public interface IEmpPresenter {
    void show(List<Employee> employees);

    void bindingEmployee(int id,String fullName, String hireDate, double salary);

}
