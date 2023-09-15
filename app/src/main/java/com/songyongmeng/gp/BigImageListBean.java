package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class BigImageListBean implements Serializable {

    private List<String> image_list;

    public List<String> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<String> image_list) {
        this.image_list = image_list;
    }
}
