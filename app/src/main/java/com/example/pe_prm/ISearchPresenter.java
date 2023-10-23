package com.example.pe_prm;

import java.util.List;

public interface ISearchPresenter {
    List<Employee> search(Employee employee);
    void show(List<Employee> list);
}
