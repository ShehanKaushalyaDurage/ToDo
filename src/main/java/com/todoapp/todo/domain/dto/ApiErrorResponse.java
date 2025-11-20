package com.todoapp.todo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiErrorResponse {

    private Integer status;
    private String message;
    private List<ErrorField> errors;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ErrorField {
        private String field;
        private String message;
    }

}
