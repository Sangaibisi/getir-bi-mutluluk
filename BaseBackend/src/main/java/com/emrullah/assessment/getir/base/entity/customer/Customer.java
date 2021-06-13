package com.emrullah.assessment.getir.base.entity.customer;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions.CustomerAddressType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

import java.util.HashMap;

/**
 * A customer.
 * 
 * @author Emrullah YILDIRIM
 */
@Document
public class Customer extends AbstractDocument {

	private String firstname, lastname;

	@Field("email")
	@Indexed(unique = true)
	private String email;
	private String password;
	private HashMap<CustomerAddressType,String> addresses;

	/**
	 * Creates a new {@link Customer} from the given firstname and lastname.
	 * 
	 * @param firstname must not be {@literal null} or empty.
	 * @param lastname must not be {@literal null} or empty.
	 */
	public Customer(String firstname, String lastname) {

		Assert.hasText(firstname);
		Assert.hasText(lastname);

		this.firstname = firstname;
		this.lastname = lastname;
	}

	protected Customer() {

	}

	/**
	 * Adds the given {@link String} to the {@link Customer}.
	 * 
	 * @param address must not be {@literal null}.
	 * @param addressType must not be null
	 */
	public void addAddress(CustomerAddressType addressType, String address) {

		Assert.notNull(address);
		Assert.notNull(addressType);

		if(this.addresses == null){
			addresses = new HashMap<>();
		}
		this.addresses.put(addressType, address);
	}

	/**
	 * Returns the firstname of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Returns the lastname of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname of the {@link Customer}.
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Returns the {@link String} of the {@link Customer}.
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the {@link Customer}'s {@link String}.
	 * 
	 * @param String must not be {@literal null}.
	 */
	public void setEmail(String String) {
		this.email = String;
	}

	/**
	 * Return the {@link Customer}'s addresses.
	 * 
	 * @return
	 */
	public HashMap<CustomerAddressType,String> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the firstname of the {@link Customer}.
	 *
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password of the {@link Customer}.
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the addresses of the {@link Customer}.
	 *
	 * @param addresses
	 */
	public void setAddresses(HashMap<CustomerAddressType, String> addresses) {
		this.addresses = addresses;
	}
}
