package com.emrullah.assessment.getir.base.entity.order;

import com.emrullah.assessment.getir.base.entity.AbstractDocument;
import com.emrullah.assessment.getir.base.entity.customer.Customer;
import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Emrullah YILDIRIM
 */
@Document
public class Order extends AbstractDocument {

    @DBRef
    private Customer customer;
    private String shippingAddress;
    private Set<LineItem> lineItems;
    private GeneralEnumerationDefinitions.OrderStatusType orderStatusType;
    private Double calculatedOrderPrice;

    public Order() {
    }

    /**
     * Creates a new {@link Order} for the given {@link Customer}.
     *
     * @param customer must not be {@literal null}.
     */
    public Order(Customer customer) {
        this(customer, null);
    }

    /**
     * Creates a new {@link Order} for the given {@link Customer}, shipping and billing {@link String}.
     *
     * @param customer        must not be {@literal null}.
     * @param shippingAddress must not be {@literal null}.
     */
    @PersistenceConstructor
    public Order(Customer customer, String shippingAddress) {

        Assert.notNull(customer);
        Assert.notNull(shippingAddress);

        this.customer = customer;
        this.shippingAddress = shippingAddress;
    }

    /**
     * Adds the given {@link LineItem} to the {@link Order}.
     *
     * @param lineItem must not be {@literal null}.
     */
    public void addOrderItem(LineItem lineItem) {
        Assert.notNull(lineItem);

        if (lineItems == null) {
            lineItems = new HashSet<>();
        }

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
     * Returns the shipping {@link String} for this order;
     *
     * @return
     */
    public String getShippingString() {
        return shippingAddress;
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

    /**
     * Returns the order shipping address of the {@link Order}.
     *
     * @return shippingAddress
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets the address of the {@link Customer}.
     *
     * @param shippingAddress
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Sets the items of the {@link Order}.
     *
     * @param lineItems
     */
    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Returns the status of the {@link Order}.
     *
     * @return orderStatusType
     */
    public GeneralEnumerationDefinitions.OrderStatusType getOrderStatusType() {
        return orderStatusType;
    }

    public void setOrderStatusType(GeneralEnumerationDefinitions.OrderStatusType orderStatusType) {
        this.orderStatusType = orderStatusType;
    }

    public void calculateOrderTotalPrice(){
        if(CollectionUtils.isEmpty(lineItems))
            this.calculatedOrderPrice = 0.0;

       calculatedOrderPrice = lineItems.stream().map(LineItem::getUnitPrice).mapToDouble(BigDecimal::doubleValue).sum();
    }
}
