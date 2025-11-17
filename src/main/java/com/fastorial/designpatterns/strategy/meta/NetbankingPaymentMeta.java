package com.fastorial.designpatterns.strategy.meta;

public record NetbankingPaymentMeta(String accountNumber, String ifscCode) implements IPaymentMetadata {

}
