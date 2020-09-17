package com.example.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

 
 
 @RequestMapping(value= {"/"}, method=RequestMethod.GET)
 public ModelAndView Home() {
  ModelAndView model = new ModelAndView();
  
  model.setViewName("home");
  return model;
 }
 
 @RequestMapping(value= {"/list"}, method=RequestMethod.GET)
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
 public String getAllByExpenseType(@PathVariable String ExpenseType,ModelMap model) {
	 
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
	 Map<String, Integer> g =new LinkedHashMap<>();
	 for(int i=0;i<graphlist.size();i++)
	 {
		 String iname = graphlist.get(i).getExpenseItem();
		 int money = g.containsKey(iname)? g.get(iname) : 0;
		 money = money + graphlist.get(i).getExpenseMoney();
		 
		 g.put(iname,money);
		 
 		// System.out.println(graphlist.get(i).getExpenseType());
		 //System.out.println(graphlist.get(i).getExpenseItem());
	 }
	 getgraphList(g);
	 List<String> ll = new ArrayList<>();
	 for(String key : g.keySet())
	 {
		 key='"'+key+'"';
		 ll.add(key);
		 
		// System.out.printf("%s %d\n",key,g.get(key));
	 }
	 	
	 model.addAttribute("itemlist",ll);
	  model.addAttribute("surveyMap", g);
	  
	
	  
	  
	  }
	  return "final_graph";
 }
 
 @ModelAttribute("graph")
 public Map<String,Integer> getgraphList(Map<String,Integer> mp) {
   
    return mp;
 }
 
 @ModelAttribute("expenseTypeList")
 public List<String> getexpenseTypeList() {
    List<String> expenseTypeList = new ArrayList<String>();
    expenseTypeList.add("Food");
    expenseTypeList.add("Travel");
    expenseTypeList.add("Shopping");
    expenseTypeList.add("Rent");
    expenseTypeList.add("Bills");
    expenseTypeList.add("Medical");
    expenseTypeList.add("Groceries");
    return expenseTypeList;
 }
 
 @ModelAttribute("expenseItemList")
 public List<String> getexpenseItemList() {
    List<String> expenseItemList = new ArrayList<String>();
    expenseItemList.add("Coffee");
    expenseItemList.add("Tea");
    expenseItemList.add("BeakFast");
    expenseItemList.add("Lunch");
    expenseItemList.add("Dinner");
    expenseItemList.add("Ola");
    expenseItemList.add("Rapido");
    expenseItemList.add("Metro");
    expenseItemList.add("Auto");
    expenseItemList.add("Clothes");
    expenseItemList.add("Electronic Gadgets");
    expenseItemList.add("House Rent");
    expenseItemList.add("Gas Bill");
    expenseItemList.add("Current Bill");
    expenseItemList.add("Recharge Bill");
    expenseItemList.add("Dish Bill");
    expenseItemList.add("Wifi Bill");
    expenseItemList.add("Tablets");
    expenseItemList.add("Hospital CheckUp");
    expenseItemList.add("Rice");
    expenseItemList.add("Vegetables");
    expenseItemList.add("Soaps");
    expenseItemList.add("Shampoo");
    return expenseItemList;
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
