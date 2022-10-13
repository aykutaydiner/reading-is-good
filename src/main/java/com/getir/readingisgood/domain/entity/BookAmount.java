package com.getir.readingisgood.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.getir.readingisgood.domain.entity.base.EntityBase;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class BookAmount extends EntityBase {

	@NotNull
	private BigDecimal amount;
	@NotNull
	private boolean active;
	@NotNull
	private LocalDateTime changeDate;
	
	public BookAmount(Long id, BigDecimal amount, boolean active, LocalDateTime changeDate) {
		setId(id);
		this.amount = amount;
		this.active = active;
		this.changeDate = changeDate;
	}

	public BookAmount() {
		super();
	}
	
	
	
}
