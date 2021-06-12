package com.emrullah.assessment.getir.base.framework.exceptions;

import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions.*;
import com.emrullah.assessment.getir.base.framework.OperationResult;

public class OperationResultException extends AbstractCommerceException {
    private OperationResult operationResult;
    private boolean buildGenericResponse;

    public OperationResultException(OperationResult operationResult) {
        super(OperationResultCodeType.ERROR.name());
        this.operationResult = operationResult;
    }

    public OperationResultException(OperationResult operationResult, boolean buildGenericResponse) {
        super(OperationResultCodeType.ERROR.name());
        this.operationResult = operationResult;
        this.buildGenericResponse = buildGenericResponse;
    }

    public OperationResult getOperationResult() {
        return this.operationResult;
    }

    public void setOperationResult(OperationResult operationResult) {
        this.operationResult = operationResult;
    }

    public boolean isBuildGenericResponse() {
        return this.buildGenericResponse;
    }

    public void setBuildGenericResponse(boolean buildGenericResponse) {
        this.buildGenericResponse = buildGenericResponse;
    }

    public String toString() {
        return "OperationResultException{operationResult=" + this.operationResult + '}';
    }
}
