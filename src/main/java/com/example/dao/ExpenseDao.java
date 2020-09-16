package com.example.dao;
import java.util.List;

import com.example.model.*;
public interface ExpenseDao {
		public List<Expense> getAllExpenses();
		
		public Expense findExpenseByExpenseType(int id);
		
		public void addExpense(Expense expense);
		
		public void updateExpense(Expense expense);
		
		public void deleteExpense(int id);
		
		public List<Expense> getAllByExpenseType(String ExpenseType);
		//public List<Expense> viewExpenseGraph(String expensetype);
		
}
