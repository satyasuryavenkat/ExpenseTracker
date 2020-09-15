package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExpenseTypeRowMapper implements RowMapper<ExpenseType>{
	
	 @Override
	 public ExpenseType mapRow(ResultSet rs, int rowNum) throws SQLException {
	  ExpenseType expensetype = new ExpenseType();
	  expensetype.setExpenseType(rs.getString("expensetype"));
	
	  return expensetype;
	 }

}
