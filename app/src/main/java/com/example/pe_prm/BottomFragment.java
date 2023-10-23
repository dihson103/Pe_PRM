package com.example.pe_prm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomFragment extends Fragment{
    public String name;
    public String HireDare;
    public String Salary;
    public BottomFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static BottomFragment newInstance() {
        BottomFragment fragment = new BottomFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }
    public void receiveData(Employee employee){

    }

}