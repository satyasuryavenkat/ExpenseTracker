package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ExpenseDaoImpl;
import com.example.model.Expense;


@Service
public class ExpenseServiceImpl implements ExpenseService {
 
 @Autowired
 private ExpenseDaoImpl expenseDao;
 

 @Override
 public List<Expense> getAllExpenses() {
  return expenseDao.getAllExpenses();
 }

 @Override
 public Expense findExpenseByExpenseType(int id) {
  return expenseDao.findExpenseByExpenseType(id);
 }

 @Override
 public void addExpense(Expense expense) {
  expenseDao.addExpense(expense);
 }

 @Override
 public void updateExpense(Expense expense) {
  expenseDao.updateExpense(expense);
 }

 @Override
 public void deleteExpense(int id) {
  expenseDao.deleteExpense(id);
 }

public List<Expense> getAllByExpenseType(String ExpenseType) {
	// TODO Auto-generated method stub
	return expenseDao.getAllExpenses();
}



 



}
