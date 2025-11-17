package com.fastorial.designpatterns.strategy.meta;

public record CardPaymentMeta(String cardNumber, String cvv, String expiryDate) implements IPaymentMetadata {

}
