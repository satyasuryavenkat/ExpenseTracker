package com.example.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.example.model.ExpenseType;
import com.example.model.ExpenseTypeRowMapper;

@Transactional
@Repository
public class ExpenseTypeDaoImpl implements ExpenseTypeDao{
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ExpenseType> getAllExpenseTypes() {
		String query = "SELECT distinct * from expensetype";
		  RowMapper<ExpenseType> rowMapper = new ExpenseTypeRowMapper();
		  List<ExpenseType> list = jdbcTemplate.query(query, rowMapper);
		  return list;
	}

}
