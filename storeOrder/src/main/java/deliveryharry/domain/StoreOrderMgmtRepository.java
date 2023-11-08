package deliveryharry.domain;

import deliveryharry.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "storeOrderMgmts",
    path = "storeOrderMgmts"
)
public interface StoreOrderMgmtRepository
    extends PagingAndSortingRepository<StoreOrderMgmt, Long> {}
