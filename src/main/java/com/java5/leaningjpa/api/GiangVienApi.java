package com.java5.leaningjpa.api;

import com.java5.leaningjpa.entity.CaCoiThi;
import com.java5.leaningjpa.entity.GiangVienSchedule;
import com.java5.leaningjpa.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GiangVienApi {
    @Autowired
    private GiangVienService giangVienService;

    @GetMapping("/sapxep")
    public ResponseEntity<?> sapXepGiangVien(@RequestBody CaCoiThi caDayDTO) {
        Map<String, Object> responseApi = new HashMap<>();
        try {
            responseApi.put("success",true);
            responseApi.put("message","call api success");
            responseApi.put("data",giangVienService.sapXepGiangVien(caDayDTO.getCaDay(),caDayDTO.getGiangVien1(),caDayDTO.getTatCaGiangVien()));
        }catch (Exception e){
            responseApi.put("success",false);
            responseApi.put("message","call api Fail");
            responseApi.put("data",null);
            e.printStackTrace();
        }
        return ResponseEntity.ok(responseApi);
    }

}
