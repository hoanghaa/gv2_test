package com.java5.leaningjpa.service.impl;

import com.java5.leaningjpa.service.GiangVienService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiangVienServiceImpl implements GiangVienService {

    @Override
    public Map<String, List<String>> sapXepGiangVien(List<String> caDay, Map<String, List<String>> giangVien1, List<String> tatCaGiangVien) {
        Map<String, List<String>> giangVien2 = new HashMap<>();

        for (int i = 0; i < caDay.size(); i++) {
            String ca = caDay.get(i);
            List<String> giangVienCoSan = new ArrayList<>(tatCaGiangVien);
            giangVienCoSan.removeAll(giangVien1.get(ca));

            List<String> giangVienDuocChon = new ArrayList<>();
            if (i > 0) {
                String caTruoc = caDay.get(i - 1);
                for (String giangVien : giangVien1.get(caTruoc)) {
                    if (giangVienCoSan.contains(giangVien) && giangVienDuocChon.size() < giangVien1.get(ca).size()) {
                        giangVienDuocChon.add(giangVien);
                        giangVienCoSan.remove(giangVien);
                    }
                }
            }

            while (giangVienDuocChon.size() < giangVien1.get(ca).size() && !giangVienCoSan.isEmpty()) {
                String giangVienDuocChonThem = giangVienCoSan.remove(0);
                giangVienDuocChon.add(giangVienDuocChonThem);
            }

            while (giangVienDuocChon.size() < giangVien1.get(ca).size()) {
                giangVienDuocChon.add(null);
                System.out.println("Không đủ giảng viên có sẵn cho ca " + ca);
            }

            giangVien2.put(ca, giangVienDuocChon);
        }

        return giangVien2;
    }
}
