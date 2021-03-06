package com.example.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		 
 		//System.out.println(graphlist.get(i).getExpenseDate());
		 //System.out.println(graphlist.get(i).getExpenseItem());
	 }
	 getgraphList(g);
	 List<String> ll = new ArrayList<>();
	 
	 int max=0;
	 String item ="";
	 for(String key : g.keySet())
	 {
		 
		 if(g.get(key)>max)
		 {
			 max=g.get(key);
			 
		 }
		 
		 key='"'+key+'"';
		 ll.add(key);
		 
		 
		 
		// System.out.printf("%s %d\n",key,g.get(key));
	 }
	 
	 for(String k: g.keySet()) {
		    if(g.get(k).equals(max)) {
		    	item+=k;
		         
		    }
		}
	 
	 model.addAttribute("max",max);
	 model.addAttribute("maxitem",item);
	 model.addAttribute("itemlist",ll);
	  model.addAttribute("surveyMap", g);
	  
	
	  
	  
	  }
	  return "final_graph";
 }
 
 @RequestMapping(value= {"/monthly"}, method=RequestMethod.GET)
 public String getDayGraph(ModelMap model) {
  
  List<Expense> lis = expenseService.getAllExpenses();
  Calendar mydate = new GregorianCalendar();
  Map<Integer, Integer> g =new LinkedHashMap<>();
  List<String> l = new ArrayList<>();
  
  for(int i=0;i<lis.size();i++)
  {
	  String date = lis.get(i).getExpenseDate();
	  DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	  Date dat=null;
	try {
		dat = format.parse(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	mydate.setTime(dat);
	
	  int month=mydate.get(Calendar.MONTH)+1;
	  
		 int money = g.containsKey(month)? g.get(month) : 0;
		 money = money + lis.get(i).getExpenseMoney();
		 g.put(month,money);
	  //System.out.println(month);
  }
  
  
	 for(Integer key : g.keySet())
	 {
		 String m="";
		 if(key==1)
		 {
			 m+='"'+"January"+'"';
		 }
		 if(key==2)
		 {
			 m+='"'+"Frebuary"+'"';
		 }
		 if(key==3)
		 {
			 m+='"'+"March"+'"';
		 }
		 if(key==4)
		 {
			 m+='"'+"April"+'"';
		 }
		 if(key==5)
		 {
			 m+='"'+"May"+'"';
		 }
		 if(key==6)
		 {
			 m+='"'+"June"+'"';
		 }
		 if(key==7)
		 {
			 m+='"'+"July"+'"';
		 }
		 if(key==8)
		 {
			 m+='"'+"August"+'"';
		 }
		 if(key==9)
		 {
			 m+='"'+"September"+'"';
		 }
		 if(key==10)
		 {
			 m+='"'+"October"+'"';
		 }
		 if(key==11)
		 {
			 m+='"'+"November"+'"';
		 }
		 if(key==12)
		 {
			 m+='"'+"December"+'"';
		 }
		
		 
		 l.add(m);
		 
		//System.out.printf("%d",key);
	 }
  
  model.addAttribute("monthlist",l);
  model.addAttribute("monthlyMap", g);
  return "monthly_graph";
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
