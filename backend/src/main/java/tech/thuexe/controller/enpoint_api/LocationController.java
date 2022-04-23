package tech.thuexe.controller.enpoint_api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.thuexe.entity.location.DistrictEntity;
import tech.thuexe.entity.location.ProvinceEntity;
import tech.thuexe.entity.location.WardEntity;
import tech.thuexe.service.LocationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${APIVersion}/location")
@Validated
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/ward")
    public ResponseEntity<List<WardEntity>> getOrders(@RequestParam int provinceId,
                                                      @RequestParam int districtId) {
        ProvinceEntity province = locationService.findProvinceById(provinceId);
        DistrictEntity district = locationService.findDistrictById(districtId);
        return ResponseEntity.ok().body(locationService.findAllWard(province, district));
    }

    @GetMapping("/province")
    public ResponseEntity<ProvinceEntity> getOrders(@RequestParam int provinceId) {
        return ResponseEntity.ok().body(locationService.findProvinceById(provinceId));
    }

}
