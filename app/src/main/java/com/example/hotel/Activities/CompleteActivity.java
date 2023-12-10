package com.example.hotel.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.hotel.R;

public class CompleteActivity extends AppCompatActivity {

    private  String Room,Price,checkin,checkout,people,ten,ho,email,sdt,night,picturPath;
    private TextView txtRoom,txtPrice,txtCheckIn,txtCheckOut,txtPeople,datPhong;
    private TextView Ten,txtEmail,Sdt;
    private ImageView img;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        Button btnBackHome = findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Gọi phương thức để trở về MainActivity
                backToHome();
            }
        });

        inview();
        Intent i = getIntent();
        Room = i.getStringExtra("NameRoom");
        Price = i.getStringExtra("price");
        checkin = i.getStringExtra("CheckIn");
        checkout = i.getStringExtra("CheckOut");
        people = i.getStringExtra("people");
        ten = i.getStringExtra("tenkh");
        ho = i.getStringExtra("ho");
        email = i.getStringExtra("Email");
        sdt = i.getStringExtra("SDT");
        night = i.getStringExtra("night");
        picturPath =i.getStringExtra("pic");

        txtRoom.setText(Room);
        txtCheckIn.setText(checkin);
        txtCheckOut.setText(checkout);
        txtPeople.setText( people);
        datPhong.setText(night +" đêm");
        Ten.setText(ten);
        txtEmail.setText(email);
        Sdt.setText(sdt);
        int drawableResId = getResources().getIdentifier(picturPath, "drawable", getPackageName());

        Glide.with(this)
                .load(drawableResId)
                .into(img);

    }

    private void backToHome() {
        Intent intent = new Intent(CompleteActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Optional, depending on your navigation requirements
    }
    private void inview(){
        txtRoom = findViewById(R.id.tenphong);
        txtCheckIn = findViewById(R.id.nhanphong);
        txtCheckOut = findViewById(R.id.traphong);
        datPhong =findViewById(R.id.datphong);
        txtPeople =findViewById(R.id.cho);
        img =findViewById(R.id.imageView3);
        Ten = findViewById(R.id.nguoidat);
        txtEmail = findViewById(R.id.txtemail);
        Sdt = findViewById(R.id.sdt);
    }
}