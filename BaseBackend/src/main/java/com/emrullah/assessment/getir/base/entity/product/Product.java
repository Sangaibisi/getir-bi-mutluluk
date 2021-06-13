package com.emrullah.assessment.getir.base.entity.product;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A product.
 * 
 * @author Emrullah YILDIRIM
 */
@Document
public class Product extends AbstractDocument {

	@Field("name")
	@Indexed(unique = true)
	private String name;
	private String description;
	private BigDecimal price;
	private BigDecimal stockCount;

	public Product() {
	}

	/**
	 * Creates a new {@link Product} with the given name.
	 * 
	 * @param name must not be {@literal null} or empty.
	 * @param price must not be {@literal null} or less than or equal to zero.
	 */
	public Product(String name, BigDecimal price) {
		this(name, price, null);
	}

	/**
	 * Creates a new {@link Product} from the given name and description.
	 * 
	 * @param name must not be {@literal null} or empty.
	 * @param price must not be {@literal null} or less than or equal to zero.
	 * @param description
	 */
	@PersistenceConstructor
	public Product(String name, BigDecimal price,  String description) {

		Assert.hasText(name, "Name must not be null or empty!");
		Assert.isTrue(BigDecimal.ZERO.compareTo(price) < 0, "Price must be greater than zero!");

		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * Creates a new {@link Product} from the given name and description.
	 *
	 * @param name must not be {@literal null} or empty.
	 * @param price must not be {@literal null} or less than or equal to zero.
	 * @param description
	 * @param stockCount
	 */
	public Product(String name, BigDecimal price, String description, BigDecimal stockCount) {
		this(name,price,description);

		Assert.isTrue(BigDecimal.ZERO.compareTo(stockCount) < 0, "Stock count must be greater than zero!");

		this.stockCount=stockCount;
	}

	/**
	 * Returns the {@link Product}'s name.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the {@link Product}'s description.
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the price of the {@link Product}.
	 * 
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the {@link Product}'s {@link String}.
	 *
	 * @param description must not be {@literal null}.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the {@link Product}'s {@link BigDecimal}.
	 *
	 * @param price must not be {@literal null}.
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Returns the {@link Product}'s stock.
	 *
	 * @return
	 */
	public BigDecimal getStockCount() {
		return stockCount;
	}

	/**
	 * Sets the {@link Product}'s {@link String}.
	 *
	 * @param stockCount must not be {@literal null}.
	 */
	public void setStockCount(BigDecimal stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		Product that = (Product) obj;

		return this.name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
