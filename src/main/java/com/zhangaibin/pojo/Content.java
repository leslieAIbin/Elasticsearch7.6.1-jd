package com.zhangaibin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Leslie
 * 2020/11/19 15:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String img;
    private String price;

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
