package com.emrullah.assessment.getir.base.framework;

import java.util.List;

public class Parameter extends AbstractSerializableType {
  protected String name;
  protected String value;
  protected Long primaryKey;
  protected Long valuePrimaryKey;
  protected List<Parameter> valueList;
  protected String resolvedValue;
  protected String shortCode;
  protected String parameterType;
  protected Boolean isDefault;

  public Parameter() {
  }

  public Parameter(String value, String shortCode) {
    this.value = value;
    this.shortCode = shortCode;
  }

  public static Parameter instance() {
    return new Parameter();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Parameter name(String name) {
    this.name = name;
    return this;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Parameter value(String value) {
    this.value = value;
    return this;
  }

  public String getResolvedValue() {
    return resolvedValue;
  }

  public void setResolvedValue(String resolvedValue) {
    this.resolvedValue = resolvedValue;
  }

  public Parameter resolvedValue(String resolvedValue) {
    this.resolvedValue = resolvedValue;
    return this;
  }

  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  public Parameter shortCode(String shortCode) {
    this.shortCode = shortCode;
    return this;
  }

  public String getParameterType() {
    return parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }

  public Parameter parameterType(String parameterType) {
    this.parameterType = parameterType;
    return this;
  }

  public List<Parameter> getValueList() {
    return valueList;
  }

  public void setValueList(List<Parameter> valueList) {
    this.valueList = valueList;
  }

  public Boolean getDefault() {
    return isDefault;
  }

  public void setDefault(Boolean aDefault) {
    isDefault = aDefault;
  }

  public Long getPrimaryKey() {
    return primaryKey;
  }

  public void setPrimaryKey(Long primaryKey) {
    this.primaryKey = primaryKey;
  }

  public Long getValuePrimaryKey() {
    return valuePrimaryKey;
  }

  public void setValuePrimaryKey(Long valuePrimaryKey) {
    this.valuePrimaryKey = valuePrimaryKey;
  }
}
