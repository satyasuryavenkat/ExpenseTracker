package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Expense;
import com.example.model.ExpenseRowMapper;

@Transactional
@Repository
public class ExpenseDaoImpl implements ExpenseDao {
 
 @Autowired
 private JdbcTemplate jdbcTemplate;

 @Override
 public List<Expense> getAllExpenses() {
  String query = "SELECT * from expense";
  RowMapper<Expense> rowMapper = new ExpenseRowMapper();
  List<Expense> list = jdbcTemplate.query(query, rowMapper);
  
  return list;
 }

 @Override
 public Expense findExpenseByExpenseType(int id) {
  String query = "SELECT * FROM expense WHERE id = ?";
  RowMapper<Expense> rowMapper = new BeanPropertyRowMapper<Expense>(Expense.class);
  Expense expense = jdbcTemplate.queryForObject(query, rowMapper, id);
  
  return expense;
 }

 @Override
 public void addExpense(Expense expense) {
  String query = "INSERT INTO expense(id, expensetype, expenseitem, expensemoney, expensedate) VALUES(?, ?, ?, ?, ?)";
  jdbcTemplate.update(query, expense.getId(),expense.getExpenseType(),expense.getExpenseItem(),expense.getExpenseMoney(),expense.getExpenseDate());
  
 }

 @Override
 public void updateExpense(Expense expense) {
  String query = "UPDATE expense SET expensetype=?, expenseitem=?, expensemoney=?, expensedate=? WHERE id=?";
  jdbcTemplate.update(query, expense.getExpenseType(),expense.getExpenseItem(),expense.getExpenseMoney(),expense.getExpenseDate(),expense.getId());
  
 }

 @Override
 public void deleteExpense(int id) {
  String query = "DELETE FROM expense WHERE id=?";
  jdbcTemplate.update(query, id);
 }

}