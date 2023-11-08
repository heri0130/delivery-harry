package deliveryharry.domain;

import deliveryharry.DeliveryApplication;
import deliveryharry.domain.DeliveryCompleted;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DeliveryMgmt_table")
@Data
//<<< DDD / Aggregate Root
public class DeliveryMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    private Long storeId;

    private Long orderId;

    private String storeStatus;

    private String orderStatus;

    private String status;

    @PostPersist
    public void onPostPersist() {}

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static DeliveryMgmtRepository repository() {
        DeliveryMgmtRepository deliveryMgmtRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryMgmtRepository.class
        );
        return deliveryMgmtRepository;
    }

    //<<< Clean Arch / Port Method
    public static void deliveryRequest(CookingComplete cookingComplete) {
        //implement business logic here:

        /** Example 1:  new item 
        DeliveryMgmt deliveryMgmt = new DeliveryMgmt();
        repository().save(deliveryMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookingComplete.get???()).ifPresent(deliveryMgmt->{
            
            deliveryMgmt // do something
            repository().save(deliveryMgmt);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
