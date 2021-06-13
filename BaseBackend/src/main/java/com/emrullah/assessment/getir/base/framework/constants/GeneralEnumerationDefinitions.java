package com.emrullah.assessment.getir.base.framework.constants;

public class GeneralEnumerationDefinitions {

    public enum OperationResultCodeType {
        SUCCESS,
        WARNING,
        APPROVED,
        ERROR,
        INFO,
        DEACTIVATION_EXIST;

        OperationResultCodeType() {
        }
    }

    public enum CustomerAddressType{
        BILLING,
        CUSTOMER;
    }
}
