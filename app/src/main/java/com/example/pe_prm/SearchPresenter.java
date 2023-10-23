package com.example.pe_prm;

import java.util.List;

public class SearchPresenter{
    private ISearchPresenter mISearchPresenter;
    public SearchPresenter(ISearchPresenter mISearchPresenter, AppDatabase db){
        this.mISearchPresenter=mISearchPresenter;
        employeeDao = db.employeeDao();
    }
    private EmployeeDao employeeDao;
    public void searchEmployee(Employee employee){
        mISearchPresenter.show(employeeDao.findByAll(employee.fullName, employee.hireDate, (double) employee.salary));
    }
}
