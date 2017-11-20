package com.eliteams.quick4j.web.model.product;

public class ProductWithBLOBs extends Product {
    private String outline;

    private String effecttent;

    private String usetent;

    private String capacitytent;

    private String ensuretent;

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    public String getEffecttent() {
        return effecttent;
    }

    public void setEffecttent(String effecttent) {
        this.effecttent = effecttent == null ? null : effecttent.trim();
    }

    public String getUsetent() {
        return usetent;
    }

    public void setUsetent(String usetent) {
        this.usetent = usetent == null ? null : usetent.trim();
    }

    public String getCapacitytent() {
        return capacitytent;
    }

    public void setCapacitytent(String capacitytent) {
        this.capacitytent = capacitytent == null ? null : capacitytent.trim();
    }

    public String getEnsuretent() {
        return ensuretent;
    }

    public void setEnsuretent(String ensuretent) {
        this.ensuretent = ensuretent == null ? null : ensuretent.trim();
    }
}