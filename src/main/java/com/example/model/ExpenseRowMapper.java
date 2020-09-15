package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExpenseRowMapper implements RowMapper<Expense>{
	
	 @Override
	 public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Expense expense = new Expense();
	  expense.setId(rs.getInt("id"));
	  expense.setExpenseType(rs.getString("expensetype"));
	  expense.setExpenseItem(rs.getString("expenseitem"));
	  expense.setExpenseMoney(rs.getInt("expensemoney"));
	  expense.setExpenseDate(rs.getString("expensedate"));
	  return expense;
	 }

}
