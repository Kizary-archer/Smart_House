package app.controllers.handler;

import app.dto.SimpleResponseDto;
import app.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExecutionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SimpleResponseDto> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(SimpleResponseDto.builder()
                        .withName(e.getFieldName())
                        .withValue(e.getMessage()).build());
    }
}
