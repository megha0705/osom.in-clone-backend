package com.Osom.demo.config;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripeConfig {
  public StripeConfig() {
        String secretKey = System.getenv("STRIPE_SECRET_KEY");

        if (secretKey == null || secretKey.isEmpty()) {
            throw new RuntimeException("STRIPE_SECRET_KEY is not set in the environment.");
        }

        Stripe.apiKey = secretKey;
    }

   public PaymentIntent createPaymentIntent(double amount , String currency)throws StripeException {
       PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount((long)amount).setCurrency(currency).build();
       return PaymentIntent.create(params);
   }
}
