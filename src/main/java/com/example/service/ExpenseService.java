package com.example.service;
import java.util.List;

import com.example.model.*;
public interface ExpenseService {
		public List<Expense> getAllExpenses();
		
		public Expense findExpenseByExpenseType(int id);
		
		public void addExpense(Expense expense);
		
		public void updateExpense(Expense expense);
		
		public void deleteExpense(int id);
		
}
