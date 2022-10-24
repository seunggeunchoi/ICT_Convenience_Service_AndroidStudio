package com.example.ItemCheck.Dto.Item;

import com.google.gson.annotations.SerializedName;

public class ItemRequestDto {
    @SerializedName("itemName")
    private String itemName;

    @SerializedName("itemDetailName")
    private String itemDetailName;

    @SerializedName("used")
    private Used used;

    // toString()을 Override 해주지 않으면 객체 주소값을 출력함
    @Override
    public String toString() {
        return "ItemResponseDto{" +
                "itemName='" + itemName + '\'' +
                ", itemDetailName='" + itemDetailName + '\'' +
                ", used=" + used +
                '}';
    }
}
