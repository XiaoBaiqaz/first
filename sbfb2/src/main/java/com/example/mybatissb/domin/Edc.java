package com.example.mybatissb.domin;

import java.awt.print.PrinterAbortException;

/**
 * 作者：17596
 * 时间：2023/5/3110:30202305
 */
public class Edc {
    private String neid;
    private String nemean;
    private String oldid;

    public String getNeid() {
        return neid;
    }

    public void setNeid(String neid) {
        this.neid = neid;
    }

    public String getNemean() {
        return nemean;
    }

    public void setNemean(String nemean) {
        this.nemean = nemean;
    }

    public String getOldid() {
        return oldid;
    }

    public void setOldid(String oldid) {
        this.oldid = oldid;
    }

    @Override
    public String toString() {
        return "Edc{" +
                "neid='" + neid + '\'' +
                ", nemean='" + nemean + '\'' +
                ", oldid='" + oldid + '\'' +
                '}';
    }
}
