package tech.thuexe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.thuexe.entity.location.DistrictEntity;
import tech.thuexe.entity.location.ProvinceEntity;
import tech.thuexe.entity.location.StreetEntity;

import java.util.List;

public interface StreetRepo extends JpaRepository<StreetEntity, Integer> {

    List<StreetEntity> findAllByProvinceAndDistrict(ProvinceEntity province, DistrictEntity district);

}
