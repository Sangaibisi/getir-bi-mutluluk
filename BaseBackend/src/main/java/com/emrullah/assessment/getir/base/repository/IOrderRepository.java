package com.emrullah.assessment.getir.base.repository;

import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.entity.order.Order;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to access {@link Order}s.
 * 
 * @author Emrullah YILDIRIM
 */
@Repository
public interface IOrderRepository extends PagingAndSortingRepository<Order, String> {

	/**
	 * Returns all {@link Order}s of the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Order> findByCustomer(Customer customer);

	List<Order> findAllByOrderStatusType(GeneralEnumerationDefinitions.OrderStatusType orderStatus);

}
