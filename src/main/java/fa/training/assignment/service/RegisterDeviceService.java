package fa.training.assignment.service;

import fa.training.assignment.entity.Device;
import fa.training.assignment.entity.DeviceUsage;
import fa.training.assignment.entity.pk.DeviceUsagePk;
import java.util.List;

public interface RegisterDeviceService {
    void save(DeviceUsage deviceUsage);
    DeviceUsage getDeviceUsageById(DeviceUsagePk id);
    List<DeviceUsage> getList();
    void deleteById(DeviceUsagePk id);
    void deleteAllByCustomerId(String customerId);
    void updateDeviceStatusBeforeDelete(String customerId);
}
