package com.budgetTracker.dto;

import java.util.Date;



import lombok.Data;

@Data
public class MonthlyBudgetMemberDTO {
	
	private Long   id;
	private Long   memberId;
	private Long   budgetId;
	private Date   joinDate;
	private Double contribution;

}
