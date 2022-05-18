package tech.thuexe.service;


import tech.thuexe.entity.*;

import java.util.List;

public interface LocationService {
    ProvinceEntity findProvinceById(int provinceId);

    DistrictEntity findDistrictById(int districtId);

    List<ProvinceEntity> findAllProvince();

    List<DistrictEntity> findAllDistrict(ProvinceEntity province);

    List<WardEntity> findAllWard(ProvinceEntity province, DistrictEntity district);

    List<StreetEntity> findAllStreet(ProvinceEntity province, DistrictEntity district);

    List<LocationEntity> findAllByLocationId(int provinceId);
}
