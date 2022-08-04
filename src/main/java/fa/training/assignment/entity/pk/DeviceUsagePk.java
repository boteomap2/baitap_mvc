package fa.training.assignment.entity.pk;


import fa.training.assignment.entity.Customer;
import fa.training.assignment.entity.Device;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Embeddable
public class DeviceUsagePk implements Serializable {
    private static final long serialVersionUID = -6791964682046574779L;

    @NotBlank(message = "Hãy chọn mã khách hàng!")
    private String customerId;

    @NotNull(message = "Hãy chọn mã máy!")
    private Integer deviceId;

    @DateTimeFormat(iso = ISO.DATE)
    @NotNull(message = "Hãy chọn ngày!")
    @Column(name = "NgayBatDauSuDung")
    private LocalDate startDateUsage;

    @DateTimeFormat(pattern = "HH:mm")
    @NotNull(message = "Hãy chọn giờ!")
    @Column(name = "GioBatDauSuDung")
    private LocalTime startTimeUsage;

    public DeviceUsagePk(Customer customer, Device device, LocalDate startDateUsage, LocalTime startTimeUsage) {
        this(customer.getCustomerId(), device.getDeviceId(), startDateUsage, startTimeUsage);
    }
}
