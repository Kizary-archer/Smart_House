package com.smart_house.web.handler;

import com.smart_house.dto.SimpleResponseDto;
import com.smart_house.exception.EntityNotFoundException;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExecutionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SimpleResponseDto> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(SimpleResponseDto.builder()
                        .withName(e.getFieldName())
                        .withValue(e.getMessage()).build());
    }

    /**
     * Обрабатывает ошибки валидации.
     *
     * @param e ошибка валидации
     * @return ошибки валидации в формате название поля - сообщение об ошибке
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationError(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();

        Map<String, String> map = errors.stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));

        return ResponseEntity.badRequest()
                .body(map);
    }

    /**
     * Обрабатывает ошибки валидации переменных пути и параметров запроса.
     *
     * @param e ошибка валидации
     * @return ошибки валидации в формате название поля - сообщение об ошибке
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleValidError(ConstraintViolationException e){
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Map<String, String> map = constraintViolations.stream()
                .collect(Collectors.toMap(this::getFieldName, ConstraintViolation::getMessage));

        return ResponseEntity.badRequest()
                .body(map);
    }

    private String getFieldName(ConstraintViolation<?> violation) {
        PathImpl path = (PathImpl) violation.getPropertyPath();
        NodeImpl node = path.getLeafNode();

        return node.getName();
    }
}
