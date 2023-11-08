package deliveryharry.domain;

import deliveryharry.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "paymentMgmts",
    path = "paymentMgmts"
)
public interface PaymentMgmtRepository
    extends PagingAndSortingRepository<PaymentMgmt, Long> {}
