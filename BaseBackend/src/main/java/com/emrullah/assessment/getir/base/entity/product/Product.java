package com.emrullah.assessment.getir.base.entity.product;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
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

	private final String name;
	private final String description;
	private final BigDecimal price;
	private final Map<String, String> attributes = new HashMap<String, String>();

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
	public Product(String name, BigDecimal price, String description) {

		Assert.hasText(name, "Name must not be null or empty!");
		Assert.isTrue(BigDecimal.ZERO.compareTo(price) < 0, "Price must be greater than zero!");

		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * Sets the attribute with the given name to the given value.
	 * 
	 * @param name must not be {@literal null} or empty.
	 * @param value
	 */
	public void setAttribute(String name, String value) {

		Assert.hasText(name);

		if (value == null) {
			this.attributes.remove(value);
		} else {
			this.attributes.put(name, value);
		}
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
	 * Returns all the custom attributes of the {@link Product}.
	 * 
	 * @return
	 */
	public Map<String, String> getAttributes() {
		return Collections.unmodifiableMap(attributes);
	}

	/**
	 * Returns the price of the {@link Product}.
	 * 
	 * @return
	 */
	public BigDecimal getPrice() {
		return price;
	}
}
