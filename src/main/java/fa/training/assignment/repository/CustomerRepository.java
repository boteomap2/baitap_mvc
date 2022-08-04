package fa.training.assignment.repository;

import fa.training.assignment.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "with tong_tien_table as ( select sddv.MaKH, sum(sddv.SoLuong * dv.DonGia) as TongTien from SUDUNGDICHVU sddv join DICHVU dv on sddv.MaDV = dv.MaDV group by sddv.MaKH ) select kh.MaKH, kh.TenKH, m.MaMay, m.ViTri, m.TrangThai, sdm.NgayBatDauSuDung, sdm.GioBatDauSuDung, sdm.ThoiGianSuDung, dv.MaDV, sddv.NgaySuDung, sddv.GioSuDung, sddv.SoLuong, ttb.TongTien from KHACHHANG kh left join SUDUNGMAY sdm on kh.MaKH = sdm.MaKH left join SUDUNGDICHVU sddv on kh.MaKH = sddv.MaKH left join MAY m on sdm.MaMay = m.MaMay left join DICHVU dv on sddv.MaDV = dv.MaDV left join tong_tien_table ttb on kh.MaKH = ttb.MaKH", nativeQuery = true)
    List<Object[]> getAllCustomerInformation();
}
