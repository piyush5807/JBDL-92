package payment;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

    PaymentService paymentService;


    WalletController(){
        this.paymentService = new PaymentService();
    }

}
