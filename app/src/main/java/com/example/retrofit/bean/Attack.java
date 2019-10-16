
package com.example.retrofit.bean;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attack {

    @SerializedName("cost")
    @Expose
    private List<String> cost = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("damage")
    @Expose
    private String damage;
    @SerializedName("convertedEnergyCost")
    @Expose
    private Integer convertedEnergyCost;

    public List<String> getCost() {
        return cost;
    }

    public void setCost(List<String> cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public Integer getConvertedEnergyCost() {
        return convertedEnergyCost;
    }

    public void setConvertedEnergyCost(Integer convertedEnergyCost) {
        this.convertedEnergyCost = convertedEnergyCost;
    }

}
