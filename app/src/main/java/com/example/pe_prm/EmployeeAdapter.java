package com.example.pe_prm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployyHolder> {
    List<Employee> employees;
    public EmployeeAdapter(List<Employee> emps) {
        employees = emps;
    }
    @NonNull
    @Override
    public EmployeeAdapter.EmployyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_card, parent, false);
        return new EmployyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployyHolder holder, int position) {
        holder.Name.setText("Full Name: " + employees.get(position).getFullName());
        holder.HireDate.setText("Hire Date: "+employees.get(position).getHireDate());
        holder.Salary.setText("Salary: "+String.valueOf( employees.get(position).getSalary()));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class EmployyHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView HireDate;
        TextView Salary;
        public EmployyHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.textView);
            HireDate = itemView.findViewById(R.id.textView2);
            Salary = itemView.findViewById(R.id.textView3);
        }
    }
}
