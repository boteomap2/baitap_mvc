package fa.training.assignment.repository;

import fa.training.assignment.entity.Device;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query("select d from Device d where d.status = 'inactive'")
    public List<Device> getInactiveList();
}
