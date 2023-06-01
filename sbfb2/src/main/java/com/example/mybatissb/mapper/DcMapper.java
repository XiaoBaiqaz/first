package com.example.mybatissb.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.mybatissb.domin.Dc;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

/**
 * 作者：17596
 * 时间：2023/5/2010:01202305
 */

@Mapper
public interface DcMapper {
    public List<Dc> findall(int pagenum,int pagesize);

    public List<Dc> findeasy(int pagenum,int pagesize);

    public int counttotal();

    public int counteasy();

    public int changerate(String id);

    public List<Dc> ct(int pagesize1,int pagesize);

    public int allcount();

    public List<Dc> searchroot(String searchby,int pagesize,int pagesize1);

    public int searchrootcount(String likestr);

    public int delroot(String delid);

    public int addroot(String id,String mean,int rate);

    public int editdata(String neid,String nemean,String oldid);




}
