package com.emrullah.assessment.getir.base.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

public abstract class AbstractSerializableType implements Serializable {
  protected final Logger logger = LogManager.getLogger(this.getClass());

  protected void printStackTrace(String msg) {
    StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
    StringBuilder traceBuilder = new StringBuilder();
    for (int i = 1; i < stackTraces.length; i++) {
      traceBuilder.append(stackTraces[i]);
      traceBuilder.append("\n");
    }
    logger.debug(msg + " - " + traceBuilder);
  }
}
