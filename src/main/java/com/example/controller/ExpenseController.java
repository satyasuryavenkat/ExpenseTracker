package com.example.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Expense;
import com.example.model.ExpenseType;
import com.example.service.ExpenseServiceImpl;
import com.example.service.ExpenseTypeServiceImpl;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

 @Autowired
 private ExpenseServiceImpl expenseService;
 
 @Autowired
 private ExpenseTypeServiceImpl expensetypeService;
 
 @RequestMapping(value= {"/", "/list"}, method=RequestMethod.GET)
 public ModelAndView getAllExpenses() {
  ModelAndView model = new ModelAndView();
  List<Expense> list = expenseService.getAllExpenses();
  
  model.addObject("expense_list", list);
  model.setViewName("expense_list");
  return model;
 }
 
 @RequestMapping(value="/update/{id}", method=RequestMethod.GET)
 public ModelAndView editExpense(@PathVariable int id) {
  ModelAndView model = new ModelAndView();
  
  Expense expense = expenseService.findExpenseByExpenseType(id);
  model.addObject("expenseForm", expense);
  
  model.setViewName("expense_form");
  return model;
 }
 
 @RequestMapping(value="/add", method=RequestMethod.GET)
 public ModelAndView addExpense() {
  ModelAndView model = new ModelAndView();
  
  Expense expense = new Expense();
  model.addObject("expenseForm", expense);
  
  model.setViewName("expense_form");
  return model;
 }
 
 @RequestMapping(value="/graph", method=RequestMethod.GET)
 public ModelAndView graphExpense() {
  ModelAndView model = new ModelAndView();
 List<ExpenseType> list = expensetypeService.getAllExpenseTypes();
  
  model.addObject("expensetype_list", list);
  model.setViewName("expensegraph_form");
  return model;
 }
 
 
 @RequestMapping(value="/view/{ExpenseType}", method=RequestMethod.GET)
 public ModelAndView getAllByExpenseType(@PathVariable String ExpenseType) {
	 ModelAndView model = new ModelAndView();
	  if(ExpenseType!=null)
	  {
		  System.out.println(ExpenseType);
	 List<Expense> li =null;
	 List<Expense> graphlist= new ArrayList<>();
 	 li=expenseService.getAllByExpenseType(ExpenseType);
	 for(int i=0;i<li.size();i++)
	 {
		 //System.out.println(li.get(i).getExpenseType());
		 //System.out.println(li.get(i).getExpenseItem());
		 if(li.get(i).getExpenseType().equalsIgnoreCase(ExpenseType))
		 {
			 graphlist.add(li.get(i));
		 }
		 
	 }
	 
	 for(int i=0;i<graphlist.size();i++)
	 {
		 System.out.println(graphlist.get(i).getExpenseType());
		 System.out.println(graphlist.get(i).getExpenseItem());
		 
		 
	 }
	  model.addObject("expenseGraph", graphlist);
	  
	  model.setViewName("expense_graph");
	  }
	  return model;
 }
 @RequestMapping(value="/save", method=RequestMethod.POST)
 public ModelAndView saveOrUpdate(@ModelAttribute("expenseForm") Expense expense) {
  if(expense.getId() != 0) {
   expenseService.updateExpense(expense);
  } else {
   expenseService.addExpense(expense);
  }
  
  return new ModelAndView("redirect:/expense/list");
 }
 
 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
 public ModelAndView deleteExpense(@PathVariable("id") int id) {
  expenseService.deleteExpense(id);
  
  return new ModelAndView("redirect:/expense/list");
 }
}
