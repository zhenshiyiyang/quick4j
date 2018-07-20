package com.eliteams.quick4j.web.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetaTable {
    private Integer id;

    private String timing;

    private Date riqi;

    private String zuozhe;

    private String zhuti;

    private String leixing;

    private String daxiao;

    private String geshi;

    private String laiyuan;

    private Integer pid;

    private String cunchu;

    private String beizhu;

    private Integer isdelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing == null ? null : timing.trim();
    }

    public Date getRiqi() {
        return riqi;
    }

    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe == null ? null : zuozhe.trim();
    }

    public String getZhuti() {
        return zhuti;
    }

    public void setZhuti(String zhuti) {
        this.zhuti = zhuti == null ? null : zhuti.trim();
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing == null ? null : leixing.trim();
    }

    public String getDaxiao() {
        return daxiao;
    }

    public void setDaxiao(String daxiao) {
        this.daxiao = daxiao == null ? null : daxiao.trim();
    }

    public String getGeshi() {
        return geshi;
    }

    public void setGeshi(String geshi) {
        this.geshi = geshi == null ? null : geshi.trim();
    }

    public String getLaiyuan() {
        return laiyuan;
    }

    public void setLaiyuan(String laiyuan) {
        this.laiyuan = laiyuan == null ? null : laiyuan.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCunchu() {
        return cunchu;
    }

    public void setCunchu(String cunchu) {
        this.cunchu = cunchu == null ? null : cunchu.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public void setRiqiStr(String riqi) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date data = format.parse(riqi);
            this.riqi = data;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}