package com.songyongmeng.gp;

import java.io.Serializable;
import java.util.List;

public class MainBean implements Serializable {


    private String name;
    private List<DataDTO> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO implements Serializable {
        private List<String> richText;

        public List<String> getRichText() {
            return richText;
        }

        public void setImage(List<String> rich) {
            this.richText = rich;
        }
    }
}
