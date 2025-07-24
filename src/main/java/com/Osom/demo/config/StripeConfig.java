package com.Osom.demo.config;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripeConfig {
public static final String SECRET_KEY = "sk_test_51RoPMhFwEmUSrI9DczYViPpbABVGdTRTEx3GHYRhn96GsZVg9uYDcvusHXBQVASzKmdmaOTHUWt2y0JwjvlMCeE900dcTYYCSa";

    public StripeConfig(){
       Stripe.apiKey = SECRET_KEY;
   }



   public PaymentIntent createPaymentIntent(double amount , String currency)throws StripeException {
       PaymentIntentCreateParams params = PaymentIntentCreateParams.builder().setAmount((long)amount).setCurrency(currency).build();
       return PaymentIntent.create(params);
   }
}
