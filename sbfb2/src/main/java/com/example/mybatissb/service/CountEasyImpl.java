package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/2422:08202305
 */
@Service
public class CountEasyImpl implements CountEasy {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public int easycount() {
        return dcMapper.counteasy();
    }
}
