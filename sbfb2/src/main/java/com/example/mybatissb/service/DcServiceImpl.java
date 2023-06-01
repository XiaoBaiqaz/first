package com.example.mybatissb.service;

import com.example.mybatissb.domin.Dc;
import com.example.mybatissb.mapper.DcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.PrinterAbortException;
import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2010:45202305
 */
@Service
public class DcServiceImpl implements DcService {
    @Autowired
    private DcMapper dcMapper;
    @Override
    public List<Dc> selectall(String pagenum,String pagesize) {
        int pn = Integer.parseInt(pagenum);
        int ps = Integer.parseInt(pagesize);
        int pstart = (pn-1) * ps;
        return dcMapper.findall(pstart,ps);
    }
}
