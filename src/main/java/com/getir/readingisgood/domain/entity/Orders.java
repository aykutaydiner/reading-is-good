package com.getir.readingisgood.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.getir.readingisgood.domain.entity.base.EntityBase;
import com.getir.readingisgood.domain.enums.OrderStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)

public class Orders extends EntityBase {

	@NotNull
	private long customerId;
	@NotNull
	private BigDecimal orderAmount;
	@NotNull
	private LocalDateTime orderDateTime;
	
	private int discountRate;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus orderStatus;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private List<OrderBook> orderBookList;


	public Orders() {
		super();
	}


	public Orders(Long id, @NotNull long customerId, @NotNull BigDecimal orderAmount,
			@NotNull LocalDateTime orderDateTime, int discountRate, @NotNull OrderStatus orderStatus,
			List<OrderBook> orderBookList) {
		setId(id);
		this.customerId = customerId;
		this.orderAmount = orderAmount;
		this.orderDateTime = orderDateTime;
		this.discountRate = discountRate;
		this.orderStatus = orderStatus;
		this.orderBookList = orderBookList;
	}

}
