package deliveryharry.common;

import deliveryharry.StoreOrderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { StoreOrderApplication.class })
public class CucumberSpingConfiguration {}
