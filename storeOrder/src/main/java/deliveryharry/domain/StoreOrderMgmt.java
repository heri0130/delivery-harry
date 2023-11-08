package deliveryharry.domain;

import deliveryharry.StoreOrderApplication;
import deliveryharry.domain.CookingComplete;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreOrderMgmt_table")
@Data
//<<< DDD / Aggregate Root
public class StoreOrderMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private String menuName;

    private Integer menuQty;

    private Long orderId;

    private Long payId;

    private Integer amount;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        CookingComplete cookingComplete = new CookingComplete(this);
        cookingComplete.publishAfterCommit();
    }

    public static StoreOrderMgmtRepository repository() {
        StoreOrderMgmtRepository storeOrderMgmtRepository = StoreOrderApplication.applicationContext.getBean(
            StoreOrderMgmtRepository.class
        );
        return storeOrderMgmtRepository;
    }

    //<<< Clean Arch / Port Method
    public static void customerOrder(Paid paid) {
        //implement business logic here:

        /** Example 1:  new item 
        StoreOrderMgmt storeOrderMgmt = new StoreOrderMgmt();
        repository().save(storeOrderMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(storeOrderMgmt->{
            
            storeOrderMgmt // do something
            repository().save(storeOrderMgmt);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void customerOrder(PaymentCanceled paymentCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        StoreOrderMgmt storeOrderMgmt = new StoreOrderMgmt();
        repository().save(storeOrderMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(paymentCanceled.get???()).ifPresent(storeOrderMgmt->{
            
            storeOrderMgmt // do something
            repository().save(storeOrderMgmt);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
