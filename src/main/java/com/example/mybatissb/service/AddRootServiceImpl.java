package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/2818:22202305
 */
@Service
public class AddRootServiceImpl implements AddRootService {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public int addcg(String id, String mean, int rate) {
        return dcMapper.addroot(id,mean,rate);
    }
}
