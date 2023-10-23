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

import java.util.List;

public class MainActivity extends AppCompatActivity implements TopFragment.ISendData,ISearchPresenter {

    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
    AppDatabase.class, "database-name").build();
    private SearchPresenter mSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.topframe, new TopFragment());
        fragmentTransaction.add(R.id.bottomFrame, new BottomFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void sendData(Employee employee) {
        BottomFragment fragment = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.bottomFrame);
        //how();

        mSearchPresenter = new SearchPresenter(this, db);

        mSearchPresenter.searchEmployee(employee);
    }

    @Override
    public List<Employee> search(Employee employee) {
        return null;
    }

    @Override
    public void show(List<Employee> list) {
        RecyclerView rec = findViewById(R.id.recyler);
        rec.setLayoutManager(new LinearLayoutManager(this));
        rec.setAdapter(new EmployeeAdapter(list));
    }
}