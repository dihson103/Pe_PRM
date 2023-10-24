package com.example.pe_prm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IEmpPresenter{

    AppDatabase db;

    EmpPresenter empPresenter;
    EditText edtFullName;
    EditText edtHireDate;
    EditText edtSalary;
    TextView txtID;

    Button btnAdd,btnSearch,btnUpdate,btnDelete,btnRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_top);

        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").allowMainThreadQueries()
                .build();

        empPresenter = new EmpPresenter(this, db);

        edtFullName = findViewById(R.id.txt_search_fullname);
        edtHireDate =  findViewById(R.id.txt_search_hiredate);
        edtSalary = findViewById(R.id.txt_search_salary);
        txtID = findViewById(R.id.txtIdInList);

        btnAdd = findViewById(R.id.btnAdd);
        btnSearch = findViewById(R.id.btnSearch);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnRefresh=findViewById(R.id.btnRefresh);

        EnableOrDisableButtonUpdateAndDelete(false);

        btnSearch.setOnClickListener(view -> {
            EnableOrDisableButtonUpdateAndDelete(false);
            String name = ((EditText)findViewById(R.id.txt_search_fullname)).getText() == null? "" : ((EditText)findViewById(R.id.txt_search_fullname)).getText().toString();
            String hireDate = ((EditText)findViewById(R.id.txt_search_hiredate)).getText() == null? "" : ((EditText)findViewById(R.id.txt_search_hiredate)).getText().toString();
            String salary = ((EditText)findViewById(R.id.txt_search_salary)).getText() == null? "" : ((EditText)findViewById(R.id.txt_search_salary)).getText().toString();
            empPresenter.search(name,hireDate,salary);
        });

        btnAdd.setOnClickListener(view -> {
            empPresenter.addEmployee(edtFullName.getText().toString(),edtHireDate.getText().toString(), Double.parseDouble(edtSalary.getText().toString()));
        });

        btnUpdate.setOnClickListener(view -> {
            empPresenter.updateEmployee(Integer.parseInt(txtID.getText().toString()),edtFullName.getText().toString(),edtHireDate.getText().toString(), Double.parseDouble(edtSalary.getText().toString()));
        });

        btnDelete.setOnClickListener(view -> {
            empPresenter.deleteEmployee(Integer.parseInt(txtID.getText().toString()));
        });

        btnRefresh.setOnClickListener(view -> {
            empPresenter.search("","","");
            EnableOrDisableButtonUpdateAndDelete(false);
            clearText();
        });

        edtHireDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (datePicker, year1, month1, day) -> {
                        String date = day + "/" + (month1 + 1) + "/" + year1;
                        edtHireDate.setText(date);
                    }, year, month, dayOfMonth);
            datePickerDialog.show();
        });
    }

    private void clearText(){
        edtFullName.setText("");
        edtHireDate.setText("");
        edtSalary.setText("");
        txtID.setText("");
    }
    @Override
    public void show(List<Employee> employees) {
        RecyclerView recyclerView = findViewById(R.id.rycl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EmployeeAdapter(employees,this));
    }

    @Override
    public void bindingEmployee(int id, String fullName, String hireDate, double salary) {
        edtFullName.setText(fullName);
        edtHireDate.setText(hireDate);
        edtSalary.setText(String.valueOf(salary));
        txtID.setText(String.valueOf(id));
    }

    @Override
    public void EnableOrDisableButtonUpdateAndDelete(boolean isEnable) {
        btnDelete.setEnabled(isEnable);
        btnUpdate.setEnabled(isEnable);
    }

    @Override
    public void ToastMessage(String satus) {
        Toast.makeText(this, satus, Toast.LENGTH_SHORT).show();
    }
}