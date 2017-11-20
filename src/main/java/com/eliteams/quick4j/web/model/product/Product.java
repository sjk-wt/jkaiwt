package com.eliteams.quick4j.web.model.product;

import java.util.Date;

public class Product {
    private String id;

    private String name;

    private String code;

    private String pcolor;

    private String effectpic;

    private String usepic;

    private String capacitypic;

    private String ensurepic;

    private String coverpic;

    private Date instarttime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPcolor() {
        return pcolor;
    }

    public void setPcolor(String pcolor) {
        this.pcolor = pcolor == null ? null : pcolor.trim();
    }

    public String getEffectpic() {
        return effectpic;
    }

    public void setEffectpic(String effectpic) {
        this.effectpic = effectpic == null ? null : effectpic.trim();
    }

    public String getUsepic() {
        return usepic;
    }

    public void setUsepic(String usepic) {
        this.usepic = usepic == null ? null : usepic.trim();
    }

    public String getCapacitypic() {
        return capacitypic;
    }

    public void setCapacitypic(String capacitypic) {
        this.capacitypic = capacitypic == null ? null : capacitypic.trim();
    }

    public String getEnsurepic() {
        return ensurepic;
    }

    public void setEnsurepic(String ensurepic) {
        this.ensurepic = ensurepic == null ? null : ensurepic.trim();
    }

    public String getCoverpic() {
        return coverpic;
    }

    public void setCoverpic(String coverpic) {
        this.coverpic = coverpic == null ? null : coverpic.trim();
    }

    public Date getInstarttime() {
        return instarttime;
    }

    public void setInstarttime(Date instarttime) {
        this.instarttime = instarttime;
    }
}