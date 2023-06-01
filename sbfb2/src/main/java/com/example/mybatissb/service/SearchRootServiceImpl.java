package com.example.mybatissb.service;

import com.example.mybatissb.domin.Dc;
import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2716:02202305
 */
@Service
public class SearchRootServiceImpl implements SearchRootService {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public List<Dc> searchroot(String sroot, String pagenum, String pagesize) {
        int i = Integer.parseInt(pagenum);
        int i1 = Integer.parseInt(pagesize);
        int i2 = (i - 1) * i1;
        return dcMapper.searchroot(sroot,i2,i1);
    }
}
