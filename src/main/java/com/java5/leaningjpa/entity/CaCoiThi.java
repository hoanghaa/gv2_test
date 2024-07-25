package com.java5.leaningjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CaCoiThi {
    private List<String> caDay;
    private Map<String, List<String>> giangVien1;
    private List<String> tatCaGiangVien;
}
