package com.example.demo.response;

import com.example.demo.entity.Anh;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPhamCustom {
    private Integer IdSanPham;
    private List<Anh> anhs;
}
