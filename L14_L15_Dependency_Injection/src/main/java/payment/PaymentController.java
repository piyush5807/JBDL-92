package payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

//    PaymentService paymentService;
//
//    PaymentController(){
//        this.paymentService = new PaymentService();
//    }


    @GetMapping("/process-payment")
    public String processPayment(@RequestParam("user") String user,
                                 @RequestParam("amount") Long amount) {

        Payment payment = new Payment(user, amount); // 100 diff objects
//        PaymentService paymentService = new PaymentService(); // 100 diff objects which is not needed at all
        paymentService.processPayment(payment);
        // 100 times but for all the 100 invocations, I am using the same paymentService object.


        return null;
    }

}
