package testab.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import testab.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "targets", path = "targets")
public interface TargetRepository
    extends PagingAndSortingRepository<Target, Long> {}
