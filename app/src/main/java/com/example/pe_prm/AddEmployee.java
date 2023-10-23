package com.example.pe_prm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

public class AddEmployee extends AppCompatActivity {

    EditText edtFullName;
    EditText edtHireDate;
    EditText edtSalary;

    EmployeeDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        edtFullName = findViewById(R.id.edtAddFullName);
        edtHireDate =  findViewById(R.id.editAddHireDate);
        edtSalary = findViewById(R.id.edtAddSalary);


    }

    public void addEmployee() {

    }
}