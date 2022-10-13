package com.getir.readingisgood.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.getir.readingisgood.domain.entity.Orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFilterResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8618381561565901772L;

	
	private int totalPage;
	private long totalElement;
	private int pageNumber;
	private List<Orders> orderList;
	
}
