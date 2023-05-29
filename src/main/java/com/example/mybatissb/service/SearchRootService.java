package com.example.mybatissb.service;

import com.example.mybatissb.domin.Dc;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2715:58202305
 */
public interface SearchRootService {
   public List<Dc> searchroot(String sroot,String pagenum,String pagesize);
}
