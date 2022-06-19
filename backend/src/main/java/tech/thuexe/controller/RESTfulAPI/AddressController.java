package tech.thuexe.controller.RESTfulAPI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AddressController {

    @GetMapping("/provinces")
    public Object getProvinces(){
        String URL = "https://thongtindoanhnghiep.co/api/city";
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }

    @GetMapping("/provinces/{id}/districts")
    public Object getDistrict(@PathVariable int id){
        String URL = "https://thongtindoanhnghiep.co/api/city/"+id+"/district";
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }

    @GetMapping("/districts/{id}/wards")
    public Object getWard( @PathVariable int id){
        String URL = "https://thongtindoanhnghiep.co/api/district/"+id+"/ward";
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }

    @GetMapping("/provinces/{id}")
    public Object getProvinceDetail( @PathVariable int id){
        String URL = "https://thongtindoanhnghiep.co/api/city/"+id;
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }

    @GetMapping("/districts/{id}")
    public Object getDistrictDetail( @PathVariable int id){
        String URL = "https://thongtindoanhnghiep.co/api/district/"+id;
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }

    @GetMapping("/wards/{id}")
    public Object getWardDetail( @PathVariable int id){
        String URL = "https://thongtindoanhnghiep.co/api/ward/"+id;
        RestTemplate template = new RestTemplateBuilder().build();
        Object _response = template.getForObject(URL,Object.class);
        return _response;
    }
}
