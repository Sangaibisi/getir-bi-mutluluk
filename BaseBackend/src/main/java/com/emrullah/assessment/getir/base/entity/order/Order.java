package com.emrullah.assessment.getir.base.entity.order;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Emrullah YILDIRIM
 */
@Document
public class Order extends AbstractDocument {

	@DBRef
	private final Customer customer;
	private final String billingString;
	private final String shippingString;
	private final Set<LineItem> lineItems = new HashSet<>();

	/**
	 * Creates a new {@link Order} for the given {@link Customer}.
	 * 
	 * @param customer must not be {@literal null}.
	 * @param shippingString must not be {@literal null}.
	 */
	public Order(Customer customer, String shippingString) {
		this(customer, shippingString, null);
	}

	/**
	 * Creates a new {@link Order} for the given {@link Customer}, shipping and billing {@link String}.
	 * 
	 * @param customer must not be {@literal null}.
	 * @param shippingString must not be {@literal null}.
	 * @param billingString can be {@literal null}.
	 */
	@PersistenceConstructor
	public Order(Customer customer, String shippingString, String billingString) {

		Assert.notNull(customer);
		Assert.notNull(shippingString);

		this.customer = customer;
		this.shippingString = shippingString;
		this.billingString = billingString;
	}

	/**
	 * Adds the given {@link LineItem} to the {@link Order}.
	 * 
	 * @param lineItem
	 */
	public void add(LineItem lineItem) {
		this.lineItems.add(lineItem);
	}

	/**
	 * Returns the {@link Customer} who placed the {@link Order}.
	 * 
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Returns the billing {@link String} for this order.
	 * 
	 * @return
	 */
	public String getBillingString() {
		return billingString != null ? billingString : shippingString;
	}

	/**
	 * Returns the shipping {@link String} for this order;
	 * 
	 * @return
	 */
	public String getShippingString() {
		return shippingString;
	}

	/**
	 * Returns all {@link LineItem}s currently belonging to the {@link Order}.
	 * 
	 * @return
	 */
	public Set<LineItem> getLineItems() {
		return Collections.unmodifiableSet(lineItems);
	}

	/**
	 * Returns the total of the {@link Order}.
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {

		BigDecimal total = BigDecimal.ZERO;

		for (LineItem item : lineItems) {
			total = total.add(item.getTotal());
		}

		return total;
	}
}
