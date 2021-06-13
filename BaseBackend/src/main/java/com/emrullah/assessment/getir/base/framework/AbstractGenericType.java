package com.emrullah.assessment.getir.base.framework;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.StringUtils;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractGenericType extends AbstractSerializableType {
  protected List<Parameter> generalParameterList = null;

  public List<Parameter> getGeneralParameterList() {
    return generalParameterList;
  }

  public void setGeneralParameterList(List<Parameter> generalParameterList) {
    this.generalParameterList = generalParameterList;
  }

  public Parameter findGeneralParameter(String shortCode) {
    return Optional.ofNullable(this.generalParameterList)
        .orElseGet(Collections::emptyList).stream()
        .filter(Objects::nonNull)
        .filter(parameter -> StringUtils.equalsIgnoreCase(shortCode, parameter.getShortCode()))
        .findFirst()
        .orElse(null);
  }

  public void addGeneralParameter(Parameter parameter) {
    if (parameter != null) {
      if (this.generalParameterList == null) {
        this.generalParameterList = new ArrayList<>();
      }

      this.generalParameterList.add(parameter);
    }
  }
}
