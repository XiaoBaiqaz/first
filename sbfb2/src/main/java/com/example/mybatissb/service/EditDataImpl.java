package com.example.mybatissb.service;

import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作者：17596
 * 时间：2023/5/3110:07202305
 */
@Service
public class EditDataImpl implements EditData {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public int editdata(String neid, String nemean, String oldid) {
        return dcMapper.editdata(neid,nemean,oldid);
    }
}
