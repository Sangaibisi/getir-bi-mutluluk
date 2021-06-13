package com.emrullah.assessment.getir.base.framework.constants;

public class GeneralEnumerationDefinitions {

    public enum OperationResultCodeType {
        SUCCESS,
        WARNING,
        ERROR,
        INFO;

        OperationResultCodeType() {
        }
    }

    public enum CustomerAddressType {
        BILLING,
        CUSTOMER;

        CustomerAddressType() {
        }
    }

    public enum OrderStatusType {
        APPROVED,
        ORDER_SHIPPED,
        ORDER_CONFIRMED,
        FULL_FINISHED;

        OrderStatusType() {
        }
    }
}
