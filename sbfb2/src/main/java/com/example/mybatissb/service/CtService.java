package com.example.mybatissb.service;

import com.example.mybatissb.domin.Dc;

import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2621:18202305
 */
public interface CtService {
    public List<Dc> getct(String pagenum,String pagesize);
}
