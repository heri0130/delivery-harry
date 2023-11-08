package deliveryharry.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryharry.config.kafka.KafkaProcessor;
import deliveryharry.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryMgmtRepository deliveryMgmtRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookingComplete'"
    )
    public void wheneverCookingComplete_DeliveryRequest(
        @Payload CookingComplete cookingComplete
    ) {
        CookingComplete event = cookingComplete;
        System.out.println(
            "\n\n##### listener DeliveryRequest : " + cookingComplete + "\n\n"
        );

        // Sample Logic //
        DeliveryMgmt.deliveryRequest(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
