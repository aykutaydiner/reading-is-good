package com.getir.readingisgood.domain.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFilterRequestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Min(0)
	private Long customerId;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;

	@Min(0)
	private int pageSize;
	@Min(0)
	private int pageNumber;
	
	
}
