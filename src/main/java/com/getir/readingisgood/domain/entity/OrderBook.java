package com.getir.readingisgood.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.getir.readingisgood.domain.entity.base.EntityBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class OrderBook extends EntityBase {

	@NotNull
	public Long bookId;
	@NotNull
	public String bookName;
	@NotNull
	public BigDecimal bookPrice;
	@NotNull
	@Min(1)
	public int orderCount;
	
	public OrderBook(Long id, long bookId, String bookName, BigDecimal bookPrice, int orderCount) {
		setId(id);
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.orderCount = orderCount;
	}

	public OrderBook() {
		super();
	}

	
	
}
