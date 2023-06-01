package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/2214:18202305
 */
@Service
public class AccountTotalImpl implements AccountTotal {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public int counttotal() {
        return dcMapper.counttotal();
    }
}
