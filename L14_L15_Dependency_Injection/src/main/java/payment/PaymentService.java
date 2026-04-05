package payment;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // To make a class singleton, we need to constructor as private and define a static function that returns an object of the given singleton class

//    private static PaymentService paymentService = null;
//
//    private PaymentService(){
//
//    }
//
//    public static PaymentService getInstance(){
//        if(paymentService == null){
//            paymentService = new PaymentService();
//        }
//
//        return paymentService;
//    }

    public void processPayment(Payment payment){
        //... TODO: Process the payment
    }
}
