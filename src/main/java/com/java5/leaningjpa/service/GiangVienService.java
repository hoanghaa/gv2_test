package com.java5.leaningjpa.service;

import java.util.List;
import java.util.Map;

public interface GiangVienService {
    Map<String, List<String>> sapXepGiangVien(List<String> caDay, Map<String, List<String>> giangVien1, List<String> tatCaGiangVien);
}
