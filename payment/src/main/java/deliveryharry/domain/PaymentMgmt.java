package deliveryharry.domain;

import deliveryharry.PaymentApplication;
import deliveryharry.domain.Paid;
import deliveryharry.domain.PaymentCanceled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PaymentMgmt_table")
@Data
//<<< DDD / Aggregate Root
public class PaymentMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer amount;

    private String userId;

    private Long orderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        PaymentCanceled paymentCanceled = new PaymentCanceled(this);
        paymentCanceled.publishAfterCommit();
    }

    public static PaymentMgmtRepository repository() {
        PaymentMgmtRepository paymentMgmtRepository = PaymentApplication.applicationContext.getBean(
            PaymentMgmtRepository.class
        );
        return paymentMgmtRepository;
    }

    //<<< Clean Arch / Port Method
    public static void orderPayment(Ordered ordered) {
        //implement business logic here:

        /** Example 1:  new item 
        PaymentMgmt paymentMgmt = new PaymentMgmt();
        repository().save(paymentMgmt);

        Paid paid = new Paid(paymentMgmt);
        paid.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(ordered.get???()).ifPresent(paymentMgmt->{
            
            paymentMgmt // do something
            repository().save(paymentMgmt);

            Paid paid = new Paid(paymentMgmt);
            paid.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void orderCanclePayment(OrderCancelled orderCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        PaymentMgmt paymentMgmt = new PaymentMgmt();
        repository().save(paymentMgmt);

        PaymentCanceled paymentCanceled = new PaymentCanceled(paymentMgmt);
        paymentCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(paymentMgmt->{
            
            paymentMgmt // do something
            repository().save(paymentMgmt);

            PaymentCanceled paymentCanceled = new PaymentCanceled(paymentMgmt);
            paymentCanceled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
