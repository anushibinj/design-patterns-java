package com.fastorial.designpatterns.strategy.client;

import com.fastorial.designpatterns.strategy.CardPaymentStrategy;
import com.fastorial.designpatterns.strategy.IPaymentStrategy;
import com.fastorial.designpatterns.strategy.NetbankingPaymentStrategy;
import com.fastorial.designpatterns.strategy.UpiPaymentStrategy;
import com.fastorial.designpatterns.strategy.context.IPaymentProcessor;
import com.fastorial.designpatterns.strategy.context.StrategicPaymentProcessor;
import com.fastorial.designpatterns.strategy.meta.CardPaymentMeta;
import com.fastorial.designpatterns.strategy.meta.NetbankingPaymentMeta;
import com.fastorial.designpatterns.strategy.meta.UpiPaymentMeta;

// CLIENT
public class AmazonPaymentService {
	public static void main(String[] args) {

		// CARD PAYMENT STARTS
		IPaymentStrategy<CardPaymentMeta> cardStrat = new CardPaymentStrategy();
		CardPaymentMeta cardMeta = new CardPaymentMeta("1234-5678-9999-0000", "888", "12-2025");
		IPaymentProcessor processor = new StrategicPaymentProcessor<>(cardStrat, cardMeta);
		String paymentResult = processor.processPayment(450.0);
		System.out.println(paymentResult);
		// CARD PAYMENT ENDS

		// UPI PAYMENT STARTS
		IPaymentStrategy<UpiPaymentMeta> upiStrat = new UpiPaymentStrategy();
		UpiPaymentMeta upiMeta = new UpiPaymentMeta("shibin@upi ");
		IPaymentProcessor upiProcessor = new StrategicPaymentProcessor<>(upiStrat, upiMeta);
		String upiPaymentResult = upiProcessor.processPayment(200.0);
		System.out.println(upiPaymentResult);
		// UPI PAYMENT ENDS

		// NETBANKING PAYMENT STARTS
		IPaymentStrategy<NetbankingPaymentMeta> netBankStrat = new NetbankingPaymentStrategy();
		NetbankingPaymentMeta netBankMeta = new NetbankingPaymentMeta("98719283719283", "HDFC0000123");
		IPaymentProcessor netBankProcessor = new StrategicPaymentProcessor<>(netBankStrat, netBankMeta);
		String netBankPaymentResult = netBankProcessor.processPayment(50000.0);
		System.out.println(netBankPaymentResult);
		// NETBANKING PAYMENT ENDS

	}
}
