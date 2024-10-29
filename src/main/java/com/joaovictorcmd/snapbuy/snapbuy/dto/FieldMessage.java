package com.joaovictorcmd.snapbuy.snapbuy.dto;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 29
 */
public class FieldMessage {
    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
