package com.toggle;

/**
 * Created by geniushkg on 3/10/17.
 */

public class Data {
    private String dataText;
    private int imgId;

    public Data(String dataText, int imgId) {
        this.dataText = dataText;
        this.imgId = imgId;
    }

    public String getDataText() {
        return dataText;
    }

    public void setDataText(String dataText) {
        this.dataText = dataText;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
