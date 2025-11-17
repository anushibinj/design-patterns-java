package com.fastorial.designpatterns.strategy;

import com.fastorial.designpatterns.strategy.meta.IPaymentMetadata;

// STRATEGY
public interface IPaymentStrategy<TMeta extends IPaymentMetadata> {
	public String processPayment(TMeta meta, Double amount);
}
