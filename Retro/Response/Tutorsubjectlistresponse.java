
package com.example.calsys.retro_custom_class.Retro.Response;

import java.util.List;

import com.google.gson.annotations.Expose;

public class Tutorsubjectlistresponse {

    @Expose
    private List<com.example.calsys.retro_custom_class.Retro.Response.Datum> data;
    @Expose
    private String status;

    public List<com.example.calsys.retro_custom_class.Retro.Response.Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
