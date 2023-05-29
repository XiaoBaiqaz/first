package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/2522:35202305
 */
@Service
public class ChangeRateImpl implements ChangeRate {

    @Autowired
    private DcMapper dcMapper;
    @Override
    public int changerate(String id) {
        return dcMapper.changerate(id);
    }
}
