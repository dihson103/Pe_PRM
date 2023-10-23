package com.example.pe_prm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IEmpPresenter{

    AppDatabase db;

    EmpPresenter empPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_top);

        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").allowMainThreadQueries()
                .build();

        empPresenter = new EmpPresenter(this);

        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(view -> {
            String name = ((EditText)findViewById(R.id.txt_search_fullname)).getText().toString();
            String hireDate = ((EditText)findViewById(R.id.txt_search_hiredate)).getText().toString();
            String salary = ((EditText)findViewById(R.id.txt_search_salary)).getText().toString();
            empPresenter.search();
        });

    }

    @Override
    public void show(List<Employee> employees) {
        RecyclerView recyclerView = findViewById(R.id.rycl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EmployeeAdapter(employees));
    }
}