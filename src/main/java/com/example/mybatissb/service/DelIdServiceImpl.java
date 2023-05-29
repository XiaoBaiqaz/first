package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/2810:36202305
 */
@Service
public class DelIdServiceImpl implements DelIdService {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public int delroot(String delstr) {
        return dcMapper.delroot(delstr);
    }
}
