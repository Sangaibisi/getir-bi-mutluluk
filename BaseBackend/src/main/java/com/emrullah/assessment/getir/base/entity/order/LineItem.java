package com.emrullah.assessment.getir.base.entity.order;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import com.emrullah.assessment.getir.base.entity.product.Product;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.Assert;

import java.math.BigDecimal;

/**
 * @author Emrullah YILDIRIM
 */
public class LineItem extends AbstractDocument {

	@DBRef
	private Product product;
	private BigDecimal totalPrice;
	private int amount;

	public LineItem() {	}

	/**
	 * Creates a new {@link LineItem} for the given {@link Product}.
	 * 
	 * @param product must not be {@literal null}.
	 */
	public LineItem(Product product) {
		this(product, 1);
	}

	/**
	 * Creates a new {@link LineItem} for the given {@link Product} and amount.
	 * 
	 * @param product must not be {@literal null}.
	 * @param amount
	 */
	public LineItem(Product product, int amount) {

		Assert.notNull(product, "The given Product must not be null!");
		Assert.isTrue(amount > 0, "The amount of Products to be bought must be greater than 0!");

		this.product = product;
		this.amount = amount;
		this.totalPrice = product.getPrice().multiply(BigDecimal.valueOf(amount));
	}

	/**
	 * Returns the {@link Product} the {@link LineItem} refers to.
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Returns the amount of {@link Product}s to be ordered.
	 * 
	 * @return
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Returns the price a single unit of the {@link LineItem}'s product.
	 * 
	 * @return the price
	 */
	public BigDecimal getUnitPrice() {
		return this.product.getPrice();
	}

	/**
	 * Returns the total for the {@link LineItem}.
	 * 
	 * @return
	 */
	public BigDecimal getTotal() {
		return totalPrice.multiply(BigDecimal.valueOf(amount));
	}
}
