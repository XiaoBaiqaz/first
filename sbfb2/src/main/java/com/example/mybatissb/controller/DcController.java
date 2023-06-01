package com.example.mybatissb.controller;

import com.example.mybatissb.domin.Dc;
import com.example.mybatissb.domin.Edc;
import com.example.mybatissb.mapper.DcMapper;
import com.example.mybatissb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：17596
 * 时间：2023/5/2011:13202305
 */
@CrossOrigin("*")
@Controller
public class DcController {
    @Autowired
    private DcService dcService;
    @Autowired
    private AccountTotal accountTotal;

    @Autowired
    private EasyService easyService;

    @Autowired
    private CountEasy countEasy;




    @ResponseBody
    @RequestMapping("/all/{pagenum}/{pagesize}")
    public List<Map> all(@PathVariable String pagenum, @PathVariable String pagesize){

        System.out.println("pagenum=====>"+pagenum);
        System.out.println("pagesize====>"+pagesize);
        List<Dc> data = dcService.selectall(pagenum, pagesize);
        int total = accountTotal.counttotal();
        Map<String, List<Dc>> datamap = new HashMap<>();
        datamap.put("data",data);
        Map<String, Integer> totalmap = new HashMap<>();
        totalmap.put("total",total);
        ArrayList<Map> maps = new ArrayList<>();
        maps.add(datamap);
        maps.add(totalmap);
        return maps;
    }


    @ResponseBody
    @GetMapping("/findeasy/{pagenum}/{pagesize}")
    public List<Map> findeasy(@PathVariable String pagenum,@PathVariable String pagesize){


        List<Dc> data = easyService.findeasy(pagenum, pagesize);
        Map<String, List<Dc>> re = new HashMap<>();
        re.put("data",data);
        Integer total = (Integer) countEasy.easycount();
        HashMap<String, Integer> recount = new HashMap<>();
        recount.put("total",total);
        ArrayList<Map> maps=new ArrayList<>();
        maps.add(re);
        maps.add(recount);
        return maps;
    }
    @Autowired
    private ChangeRate changeRate;

    @ResponseBody
    @GetMapping("/sc/{sc}")
    public String sc(@PathVariable String sc){
        changeRate.changerate(sc);
        return "收藏成功";
    }
    @Autowired
    private CtService ctService;
    @Autowired
    private GetAllCount getAllCount;
    @ResponseBody
    @GetMapping("/ct/{pagenum}/{pagesize}")
    public List<Map> ct(@PathVariable String pagenum,@PathVariable String pagesize ){

        int allcount = getAllCount.getallcont();
        List<Dc> data = ctService.getct(pagenum,pagesize);
        HashMap<String,List<Dc>> dcmap = new HashMap<>();
        dcmap.put("data",data);
        HashMap<String, Integer> total = new HashMap<>();
        total.put("total",allcount);
        ArrayList<Map> map =new ArrayList<>();
        map.add(dcmap);
        map.add(total);
        return map;
    }

    @Autowired
    private SearchRootService searchRootService;

    @Autowired
    private SearchCountService searchCountService;
    @ResponseBody
    @GetMapping("/searchroot/{pagenum}/{pagesize}/{search_by}")
    public List<Map> searchroot(@PathVariable String search_by,@PathVariable String pagenum,@PathVariable String pagesize){

        List<Dc> data = searchRootService.searchroot(search_by, pagenum, pagesize);
        int total =searchCountService.countsearch(search_by);
        HashMap<String,Integer> countmap=new HashMap<>();
        countmap.put("total",total);
        HashMap<String,List<Dc>> datamap=new HashMap<>();
        datamap.put("data",data);
        ArrayList<Map> maps = new ArrayList<>();
        maps.add(datamap);
        maps.add(countmap);
        return maps;
    }


    @Autowired
    private DelIdService delIdService;
    @ResponseBody
    @PostMapping("/delroot")
    public int delroot(@RequestBody Map<String,String> params){
        /*System.out.println(params.get("id"));*/
        String id = params.get("id");
        return delIdService.delroot(id);

    }

    @Autowired
    private AddRootService addRootService;
    @ResponseBody
    @PostMapping("/insertcg")
    public String insertcg(@RequestBody Dc params){
        /*String  id = (String)params.get("id");
        String mean = (String) params.get("mean");
        int rate = (int)params.get("rate");*/

        System.out.println(params);
        addRootService.addcg(params.getId(),params.getMean(),params.getRate());

        return "添加成功!";


        

    }

    @Autowired
    private EditData editData;
    @ResponseBody
    @PutMapping("/eddata")
    public String eddata(@RequestBody Edc edc){



       /* System.out.println(edc.toString());*/
        String neid = edc.getNeid();
        /*System.out.println("neid:"+neid);*/
        String nemean = edc.getNemean();
        /*System.out.println("nemean:"+nemean);*/
        String oldid = edc.getOldid();
       /* System.out.println("oldid:"+oldid);*/
        int i = editData.editdata(neid, nemean, oldid);
        if(i==1){return "修改成功!";}else{return "修改失败!";}



    };



}
