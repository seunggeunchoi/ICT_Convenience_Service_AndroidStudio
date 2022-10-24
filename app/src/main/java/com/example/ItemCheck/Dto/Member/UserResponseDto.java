package com.example.ItemCheck.Dto.Member;

import com.google.gson.annotations.SerializedName;

public class UserResponseDto {

    @SerializedName("studentId")
    private String studentId;

    @SerializedName("password")
    private String password;

    public UserResponseDto(String studentId, String password) {
        this.studentId = studentId;
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "studentId='" + studentId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
