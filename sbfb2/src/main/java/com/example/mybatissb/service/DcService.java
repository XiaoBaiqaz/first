package com.example.mybatissb.service;

import com.example.mybatissb.domin.Dc;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2010:43202305
 */

public interface DcService {

    public List<Dc> selectall(String pagenum,String pagesize);


}
