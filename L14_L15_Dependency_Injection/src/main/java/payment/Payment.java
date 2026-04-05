package payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Payment {

    private String user;
    private Long amount;

    private static Logger logger = LoggerFactory.getLogger(Payment.class);

    Payment(){
        logger.info("Payment being initialized, this - {}", this);
    }

    public Payment(String user, Long amount) {
        this.user = user;
        this.amount = amount;
        logger.info("Payment being initialized via parameterized constructor, this - {}", this);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
