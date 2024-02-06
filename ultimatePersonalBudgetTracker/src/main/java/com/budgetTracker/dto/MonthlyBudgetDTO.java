package com.budgetTracker.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MonthlyBudgetDTO {
	
	
	 private Long id;
	 private Date startDate;
	 private Date endDate;

}
