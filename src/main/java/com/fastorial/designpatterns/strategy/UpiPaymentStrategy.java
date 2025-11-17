package com.fastorial.designpatterns.strategy;

import com.fastorial.designpatterns.strategy.meta.UpiPaymentMeta;

public class UpiPaymentStrategy implements IPaymentStrategy<UpiPaymentMeta> {

	@Override
	public String processPayment(UpiPaymentMeta meta, Double amount) {
		return "Payment of " + amount + " processed using UPI ID " + meta.upiId();
	}

}
