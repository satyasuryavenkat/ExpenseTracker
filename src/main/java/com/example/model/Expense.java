package com.example.model;

public class Expense {
	
	private String ExpenseType;
	private int ExpenseMoney;
	private int id;
	private String ExpenseItem;
	private String ExpenseDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getExpenseType() {
		return ExpenseType;
	}
	public void setExpenseType(String expenseType) {
		ExpenseType = expenseType;
	}
	public int getExpenseMoney() {
		return ExpenseMoney;
	}
	public void setExpenseMoney(int expenseMoney) {
		ExpenseMoney = expenseMoney;
	}
	public String getExpenseItem() {
		return ExpenseItem;
	}
	public void setExpenseItem(String expenseItem) {
		ExpenseItem = expenseItem;
	}
	public String getExpenseDate() {
		return ExpenseDate;
	}
	public void setExpenseDate(String expenseDate) {
		ExpenseDate = expenseDate;
	}

}
