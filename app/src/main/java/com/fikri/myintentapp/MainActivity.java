package com.fikri.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this,MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Fikri");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveWithDataIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "0989897889";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
//               ACTION_DIAL menentukan intent filter dari aplikasi-aplikasi yang bisa menangani action tersebut. Di sini aplikasi yang memiliki kemampuan untuk komunikasi akan muncul pada opsi pilihan, sebagaimana ditampilkan ke pengguna.
//                Uri adalah sebuah untaian karakter yang digunakan untuk mengidentifikasi nama, sumber, atau layanan di internet sesuai dengan RFC 2396. Pada Uri.parse("tel:"+phoneNumber) kita melakukan parsing Uri dari bentuk teks string menjadi sebuah obyek uri dengan menggunakan metode static parse(String)
//                Dimana “tel” adalah sebuah skema yang disepakati untuk sumber daya telepon dan phoneNumber adalah variabel string yang bernilai “081210841382”. Skema lain dari Uri seperti “geo” untuk peta, “http” untuk browser sisanya bisa dilihat di halaman ini :
                break;
        }
    }

}
