package com.fastorial.designpatterns.strategy;

import com.fastorial.designpatterns.strategy.meta.CardPaymentMeta;

public class CardPaymentStrategy implements IPaymentStrategy<CardPaymentMeta> {

	@Override
	public String processPayment(CardPaymentMeta meta, Double amount) {
		return "Payment of " + amount + " processed using CARD ending " + meta.cardNumber();
	}

}
