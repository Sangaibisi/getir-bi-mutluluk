package com.emrullah.assessment.getir.base.framework;

import com.emrullah.assessment.getir.base.framework.constants.GeneralEnumerationDefinitions.*;
import com.emrullah.assessment.getir.base.framework.exceptions.OperationResultException;
import org.springframework.http.HttpStatus;

import java.util.Objects;


public class OperationResult extends AbstractGenericType {
    protected HttpStatus resultCode;
    protected String operationResultCode;
    protected String description;
    protected String transactionId;
    protected Long version;

    public OperationResult() {
    }

    public static OperationResult newInstance(HttpStatus resultCode) {
        OperationResult result = new OperationResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static OperationResult newInstance(HttpStatus resultCode, String transactionId) {
        OperationResult result = new OperationResult();
        result.setResultCode(resultCode);
        result.setTransactionId(transactionId);
        return result;
    }

    public static OperationResult createErrorResult(String operationResultCode) {
        OperationResult result = newInstance(HttpStatus.INTERNAL_SERVER_ERROR);
        result.setOperationResultCode(operationResultCode);
        return result;
    }

    public static OperationResult createErrorResult(HttpStatus operationResultCode) {
        return newInstance(operationResultCode);
    }

    public static OperationResult createErrorResult() {
        return newInstance(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static OperationResult createErrorResult(HttpStatus resultCode, String description) {
        OperationResult result = createErrorResult(resultCode);
        result.setDescription(description);
        return result;
    }

    public static OperationResult createErrorResult(String operationResultCode, String description) {
        OperationResult result = createErrorResult(operationResultCode);
        result.setDescription(description);
        return result;
    }

    public static OperationResult createSuccessResult(String operationResultCode) {
        OperationResult result = newInstance(HttpStatus.OK);
        result.setOperationResultCode(operationResultCode);
        return result;
    }

    public static OperationResult createSuccessResult() {
        OperationResult result = newInstance(HttpStatus.OK);
        return result;
    }

    public static OperationResult createSuccessResult(String operationResultCode, String description) {
        OperationResult result = createSuccessResult(operationResultCode);
        result.setDescription(description);
        return result;
    }

    public OperationResult withDescription(String description) {
        this.description = description;
        return this;
    }

    public HttpStatus getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(HttpStatus resultCode) {
        this.resultCode = resultCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperationResultCode() {
        return this.operationResultCode;
    }

    public void setOperationResultCode(String operationResultCode) {
        this.operationResultCode = operationResultCode;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof OperationResult)) {
            return false;
        } else {
            OperationResult that = (OperationResult)o;
            return this.getResultCode() == that.getResultCode() && Objects.equals(this.getOperationResultCode(), that.getOperationResultCode())
                    && Objects.equals(this.getDescription(), that.getDescription())
                    && Objects.equals(this.getTransactionId(), that.getTransactionId());
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.getResultCode(), this.getOperationResultCode(), this.getDescription(), this.getTransactionId()});
    }

    public String toString() {
        return "OperationResult{resultCode=" + this.resultCode + ", operationResultCode='" + this.operationResultCode + '\'' + ", description='" + this.description + '\'' + ", reMessageList=" + '}';
    }
}
