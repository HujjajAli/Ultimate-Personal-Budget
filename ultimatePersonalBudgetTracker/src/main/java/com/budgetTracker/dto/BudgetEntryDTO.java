package com.budgetTracker.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BudgetEntryDTO {
	
	
	 private Long   id;
	 private Date   date;
	 private Double amount;
	 private String description;
	 private Long   memberId;
	 private String memberName;
	 private Long   monthlyBudgetId;

}
