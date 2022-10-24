package com.example.ItemCheck.retrofit;

import com.example.ItemCheck.Dto.Item.ItemRequestDto;
import com.example.ItemCheck.Dto.Item.ItemResponseDto;
import com.example.ItemCheck.Dto.Member.UserResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("/api/items/{id}")
    Call<List<ItemResponseDto>> getItems();

    @GET("/api/items")
    Call<ItemResponseDto> getItem(@Path("id") Long id);

    @POST("/api/users/signup")
    Call<UserResponseDto> saveMember(@Body UserResponseDto userResponseDto);

    @POST("/api/users/login")
    Call<UserResponseDto> loginMember(@Body UserResponseDto userResponseDto);

    // item
    @GET("/api/items")
    Call<ItemResponseDto> getItems(@Body ItemRequestDto itemRequestDto);

    @POST("/api/items")
    Call<ItemRequestDto> saveItem(@Body ItemRequestDto itemRequestDto);
}
