package fa.training.assignment.repository;

import fa.training.assignment.entity.ServiceUsage;
import fa.training.assignment.entity.pk.ServiceUsagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterServiceRepository extends JpaRepository<ServiceUsage, ServiceUsagePk> {
    @Modifying
    @Query("delete from ServiceUsage where serviceUsagePk.customerId = :customerId")
    public void deleteAllByCustomerId(@Param("customerId") String customerId);
}
