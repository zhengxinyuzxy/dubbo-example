package com.mellow.pojo;

public class Mobel {
    private String num;
    private String brand;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Mobel{" +
                "num='" + num + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
