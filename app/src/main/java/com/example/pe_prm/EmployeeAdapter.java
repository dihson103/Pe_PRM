package com.example.pe_prm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployyHolder> {
    List<Employee> employees;
    CardView cardView;
    IEmpPresenter iEmpPresenter;
    public EmployeeAdapter(List<Employee> emps,IEmpPresenter iEmpPresenter) {
        this.iEmpPresenter = iEmpPresenter;
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
        holder.Name.setText(employees.get(position).getFullName());
        holder.HireDate.setText(employees.get(position).getHireDate());
        holder.Salary.setText(String.valueOf( employees.get(position).getSalary()));
        holder.id.setText(String.valueOf(employees.get(position).getId()));
        holder.cardView.setOnClickListener(view -> {
            iEmpPresenter.bindingEmployee(employees.get(position).getId(),employees.get(position).getFullName(),employees.get(position).getHireDate(),employees.get(position).getSalary());
        });

    }
    @Override

    public int getItemCount() {
        return employees.size();
    }

    public class EmployyHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView Name;
        TextView HireDate;
        TextView Salary;
        CardView cardView;
        public EmployyHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtID);
            Name = itemView.findViewById(R.id.textView);
            HireDate = itemView.findViewById(R.id.textView2);
            Salary = itemView.findViewById(R.id.textView3);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
