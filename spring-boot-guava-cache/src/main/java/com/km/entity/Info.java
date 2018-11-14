package com.km.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/9/22.
 */
@Data
public class Info {
    private String phone;
    private String address;


    public Info(String phone, String address) {
        this.phone = phone;
        this.address = address;
    }
}
