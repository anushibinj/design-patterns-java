package com.fastorial.designpatterns.strategy;

import com.fastorial.designpatterns.strategy.meta.NetbankingPaymentMeta;

public class NetbankingPaymentStrategy implements IPaymentStrategy<NetbankingPaymentMeta> {

	@Override
	public String processPayment(NetbankingPaymentMeta meta, Double amount) {
		return "Payment of " + amount + " processed using NETBANKING account " + meta.accountNumber();
	}

}
