package fa.training.assignment.repository;

import fa.training.assignment.entity.DeviceUsage;
import fa.training.assignment.entity.pk.DeviceUsagePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDeviceRepository extends JpaRepository<DeviceUsage, DeviceUsagePk> {
    @Modifying
    @Query("delete from DeviceUsage where deviceUsagePk.customerId = :customerId")
    public void deleteAllByCustomerId(@Param("customerId") String customerId);

    @Modifying
    @Query(value = "update MAY set TrangThai = 'inactive' from MAY m join SUDUNGMAY sdm on m.MaMay = sdm.MaMay where sdm.MaKH = :customerId", nativeQuery = true)
    public void updateDeviceStatusBeforeDelete(@Param("customerId") String customerId);
}
