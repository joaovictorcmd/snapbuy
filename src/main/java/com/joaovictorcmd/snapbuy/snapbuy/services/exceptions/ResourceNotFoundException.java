package com.joaovictorcmd.snapbuy.snapbuy.services.exceptions;

/**
 * @author joaovictorcmd
 * @date 2024 Oct 28
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
