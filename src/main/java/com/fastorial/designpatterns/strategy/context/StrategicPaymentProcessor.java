package com.fastorial.designpatterns.strategy.context;

import com.fastorial.designpatterns.strategy.IPaymentStrategy;
import com.fastorial.designpatterns.strategy.meta.IPaymentMetadata;

public class StrategicPaymentProcessor<TMeta extends IPaymentMetadata> implements IPaymentProcessor {

	private final IPaymentStrategy<TMeta> strategy;
	private final TMeta meta;

	public StrategicPaymentProcessor(IPaymentStrategy<TMeta> strategy, TMeta meta) {
		super();
		this.strategy = strategy;
		this.meta = meta;
	}

	@Override
	public String processPayment(Double amount) {
		return strategy.processPayment(meta, amount);
	}

}
