package fa.training.assignment.entity.pk;

import fa.training.assignment.entity.Customer;
import fa.training.assignment.entity.Service;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
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
public class ServiceUsagePk implements Serializable {
    private String customerId;
    private String serviceId;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "NgaySuDung")
    private LocalDate dateUsage;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "GioSuDung")
    private LocalTime timeUsage;

    public ServiceUsagePk(Customer customer, Service service, LocalDate dateUsage, LocalTime timeUsage) {
        this(customer.getCustomerId(), service.getServiceId(), dateUsage, timeUsage);
    }
}
