package com.example.pe_prm;

import java.util.ArrayList;
import java.util.List;

public class EmpPresenter {
    private IEmpPresenter mIEmpPresenter;

    private List<Employee> list = new ArrayList<>();
    private  EmployeeDao dao;

    public  EmpPresenter(IEmpPresenter mIEmpPresenter, AppDatabase db){
        this.mIEmpPresenter = mIEmpPresenter;
        dao = db.employeeDao();
    }

    void search(String fullName, String hireDate, String salary){
        if(fullName.isEmpty() && hireDate.isEmpty() && salary.isEmpty())
            mIEmpPresenter.show(dao.getAll());
        else if(fullName.isEmpty() && hireDate.isEmpty())
            mIEmpPresenter.show(dao.findBySalary(Double.parseDouble(salary)));
        else if(fullName.isEmpty() && salary.isEmpty())
            mIEmpPresenter.show(dao.findByHireDate(hireDate));
        else if(hireDate.isEmpty() && salary.isEmpty())
            mIEmpPresenter.show(dao.findByFullName(fullName));
        else if(fullName.isEmpty())
            mIEmpPresenter.show(dao.findByHireDateAndSalary(hireDate, Double.parseDouble(salary)));
        else if(hireDate.isEmpty())
            mIEmpPresenter.show(dao.findByFullNameAndSalary(fullName, Double.parseDouble(salary)));
        else if(salary.isEmpty())
            mIEmpPresenter.show(dao.findByFullNameAndHireDate(fullName, hireDate));
        else
            mIEmpPresenter.show(dao.findByAll(fullName, hireDate, Double.parseDouble(salary)));
    }

    void addEmployee(String fullName, String hireDate, String salary){
        try {
            dao.insertAll(new Employee( fullName, hireDate, salary));
            mIEmpPresenter.show(dao.getAll());
            mIEmpPresenter.ToastMessage("Add successfully");
        }
        catch (Exception e) {
            mIEmpPresenter.ToastMessage(e.getMessage());
        }
    }

    void updateEmployee(int id, String fullName, String hireDate, double salary){
        dao.update(id, fullName, hireDate, salary);
        mIEmpPresenter.show(dao.getAll());
        mIEmpPresenter.ToastMessage("Update successfully");
    }

    void deleteEmployee(int id){
        dao.deleteById(id);
        mIEmpPresenter.show(dao.getAll());
        mIEmpPresenter.ToastMessage("Delete successfully");
    }

    void EnableOrDisableButtonUpdateAndDelete(boolean isEnable){
        mIEmpPresenter.EnableOrDisableButtonUpdateAndDelete(isEnable);
    }


}
