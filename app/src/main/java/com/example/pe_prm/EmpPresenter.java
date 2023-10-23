package com.example.pe_prm;

import java.util.ArrayList;
import java.util.List;

public class EmpPresenter {
    private IEmpPresenter mIEmpPresenter;

    private List<Employee> list = new ArrayList<>();

    public  EmpPresenter(IEmpPresenter mIEmpPresenter){
        this.mIEmpPresenter = mIEmpPresenter;
    }

    void search(){
        list.add(new Employee(1,"huy", "12312",123123));
        list.add(new Employee(2,"huy", "12312",123123));
        list.add(new Employee(3,"huy", "12312",123123));
        list.add(new Employee(4,"huy", "12312",123123));
        list.add(new Employee(5,"huy", "12312",123123));
        mIEmpPresenter.show(list);
    }
}
