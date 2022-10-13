package com.getir.readingisgood.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.getir.readingisgood.domain.dto.OrderMonthlyStatisticsResponseDTO;
import com.getir.readingisgood.domain.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

	@Query(value = "select MONTHNAME(o.order_date_time) as monthName, year(o.order_date_time) as yearNumber , count(o.id) as totalOrderCount, sum(ob.order_count) as totalBookCount, sum(o.order_amount) as totalAmount from Orders o, order_book ob where ob.order_id = o.id group by YEAR(o.order_date_time), MONTHNAME(o.order_date_time) ", nativeQuery = true)
	List<OrderMonthlyStatisticsResponseDTO> getOrderMonthlyStatistics();

	@Query(value = " select o from Orders o where (:customerId is null or o.customerId = :customerId) and (:startDate is null or o.orderDateTime > :startDate) and (:endDate is null or o.orderDateTime < :endDate)")
	Page<Orders> getOrdersByFilter(@Param("customerId") Long customerId, @Param("startDate")LocalDateTime startDate, @Param("endDate")LocalDateTime endDate, Pageable page);

}
