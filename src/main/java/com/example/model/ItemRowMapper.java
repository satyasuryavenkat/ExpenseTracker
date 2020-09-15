package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item>{
	
	 @Override
	 public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
	  Item item = new Item();
	  item.setItemName(rs.getString("itemname"));
	  item.setExpenseType(rs.getString("itemexpensetype"));
	
	  return item;
	 }

}
