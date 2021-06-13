# getir-bi-mutluluk assessment
## For open api url ==> http://localhost:5000/swagger-ui/index.html

### For interceptor logging in package com.emrullah.assessment.getir.base.spring.interceptor

###All documents must extends BaseBackend.src.main.java.com.emrullah.assessment.getir.base.entity.AbstractDocument.java class for audit logging and common props
###These endpoints have public access
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            // other public endpoints of your API may be appended to this array
            "/home/**"