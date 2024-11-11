package org.itSurvey.survey.utils.aspect;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.itSurvey.survey.utils.exception.ResourceNotFoundException;

@Aspect
@Component
@RequiredArgsConstructor
public class IdExistsAspect {
    private final EntityManager entityManager;

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) && args(.., @IdExists(entityClass = #entityClass) Long id)")
    public void checkEntityExists(JoinPoint joinPoint, Long id, Class<?> entityClass) {
        Object entity = entityManager.find(entityClass, id);
        if(entity == null) {
            throw new ResourceNotFoundException("entity not found!");
        }
    }
}
