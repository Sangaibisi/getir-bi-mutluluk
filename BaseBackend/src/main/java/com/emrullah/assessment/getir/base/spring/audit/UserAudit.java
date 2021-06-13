package com.emrullah.assessment.getir.base.spring.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAudit implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String uname = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.of(uname);
    }
}
