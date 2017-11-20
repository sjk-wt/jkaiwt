/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eliteams.quick4j.core.util.responsebeans;

/**
 *
 * @author lucas
 */
public class ResultJsonWithData extends ResultJson {

    private Object data;

    public ResultJsonWithData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
