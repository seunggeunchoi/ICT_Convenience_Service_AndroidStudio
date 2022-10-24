package com.example.ItemCheck;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ItemCheck.Dto.Member.UserResponseDto;
import com.example.ItemCheck.retrofit.RetrofitAPI;
import com.example.ItemCheck.retrofit.RetrofitClient;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private EditText et_id, et_pass;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);

        btn_login = findViewById(R.id.btn_login);

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        RetrofitAPI retrofitAPI = RetrofitClient.getRetrofitAPI();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String studentId = et_id.getText().toString();
                String password = et_pass.getText().toString();

                UserResponseDto userResponseDto = new UserResponseDto(studentId, password);

                retrofitAPI.loginMember(userResponseDto).enqueue(new Callback<UserResponseDto>() {
                    // 통신 성공
                    @Override
                    public void onResponse(Call<UserResponseDto> call, retrofit2.Response<UserResponseDto> response) {
                        // HTTP 상태코드 저장
                        Integer resultCode = response.code();

                        System.out.println("resultCode = " + resultCode);

                        if(resultCode.equals(200)) {
                            Toast.makeText(LoginActivity.this, "로그인되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            LoginActivity.this.finish();
                        } else if(resultCode.equals(404)) {
                            Toast.makeText(LoginActivity.this, "아이디 유저를 찾을 수 없습니다.", Toast.LENGTH_SHORT).show();
                        } else if(resultCode.equals(406)) {
                            Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setTitle("알림")
                                    .setMessage("예기치 못한 오류가 발생하였습니다.")
                                    .setPositiveButton("확인", null)
                                    .create()
                                    .show();
                        }
                    }
                    // 통신 실패
                    @Override
                    public void onFailure(Call<UserResponseDto> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "통신에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(LoginActivity.class.getName()).log(Level.SEVERE, "로그인 통신 실패!");
                    }
                });
            }
        });
    }
}