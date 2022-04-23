package tech.thuexe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.thuexe.entity.location.DistrictEntity;
import tech.thuexe.entity.location.ProvinceEntity;
import tech.thuexe.entity.location.StreetEntity;
import tech.thuexe.entity.location.WardEntity;
import tech.thuexe.repository.DistrictRepo;
import tech.thuexe.repository.ProvinceRepo;
import tech.thuexe.repository.StreetRepo;
import tech.thuexe.repository.WardRepo;
import tech.thuexe.service.LocationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final ProvinceRepo provinceRepo;
    private final DistrictRepo districtRepo;
    private final WardRepo wardRepo;
    private final StreetRepo streetRepo;


    @Override
    public ProvinceEntity findProvinceById(int provinceId) {
        return provinceRepo.findById(provinceId).get();
    }

    @Override
    public DistrictEntity findDistrictById(int districtId) {
        return districtRepo.findById(districtId).get();
    }

    @Override
    public List<ProvinceEntity> findAllProvince() {
        return provinceRepo.findAll();
    }

    @Override
    public List<DistrictEntity> findAllDistrict(ProvinceEntity province) {
        return districtRepo.findAllByProvince(province);
    }

    @Override
    public List<WardEntity> findAllWard(ProvinceEntity province, DistrictEntity district) {
        return wardRepo.findAllByProvinceAndDistrict(province, district);
    }

    @Override
    public List<StreetEntity> findAllStreet(ProvinceEntity province, DistrictEntity district) {
        return streetRepo.findAllByProvinceAndDistrict(province, district);
    }
}
