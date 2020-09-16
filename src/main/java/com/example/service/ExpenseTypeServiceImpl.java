package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ExpenseTypeDaoImpl;
import com.example.model.ExpenseType;


@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
 
 @Autowired
 private ExpenseTypeDaoImpl expensetypeDao;
 

 @Override
 public List<ExpenseType> getAllExpenseTypes() {
  return expensetypeDao.getAllExpenseTypes();
 }


 



}
