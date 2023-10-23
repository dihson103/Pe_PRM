package com.example.pe_prm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopFragment extends Fragment {

    private ISendData mISendata;
    public interface ISendData {
        void sendData(Employee employee);
    }
    public TopFragment() {
        // Required empty public constructor
    }

    public static TopFragment newInstance() {
        TopFragment fragment = new TopFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mISendata = (ISendData) getActivity();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String name = view.findViewById(R.id.txt_search_fullname).toString();
        String hiredate = view.findViewById(R.id.txt_search_hiredate).toString();
        String salary = view.findViewById(R.id.txt_search_salary).toString();
        Button bt = view.findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mISendata.sendData(new Employee(1, name, hiredate, Double.parseDouble(salary)));

//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                BottomFragment.newInstance().name=name;
//                BottomFragment.newInstance().HireDare=hiredate;
//                BottomFragment.newInstance().Salary=salary;
//                fragmentManager.beginTransaction().replace(R.id.bottomFrame, BottomFragment.newInstance()).commit();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top, container, false);
    }
}