package plugin.id.kuis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    private EditText etCode, etName, etType, etPrice;
    private Button btnTambah, btnLihat;

    String extr_id;
    String extr_code;
    String extr_name;
    String extr_type;
    String extr_price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        extr_id = i.getStringExtra("id");
        extr_code = i.getStringExtra("code");
        extr_name = i.getStringExtra("name");
        extr_type = i.getStringExtra("type");
        extr_price = i.getStringExtra("price");

        etCode = findViewById(R.id.etCode);
        etName = findViewById(R.id.etName);
        etType = findViewById(R.id.etType);
        etPrice = findViewById(R.id.etPrice);

        btnTambah = findViewById(R.id.btnTambah);
        btnLihat = findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LihatActivity.class);
                startActivity(intent);
            }
        });

        kondisi(extr_id);
    }

    private void insertUser() {

//        boolean snim = etNim.getText().toString().length()==0;
//        etNim.setError("Email diperlukan!");

        String scode = etCode.getText().toString();
        String sname = etName.getText().toString();
        String stype = etType.getText().toString();
        String sprice = etPrice.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Barang> call = apiInterface.insertUser(scode, sname, stype, sprice);
        call.enqueue(new Callback<Barang>() {
            @Override
            public void onResponse(Call<Barang> call, Response<Barang> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Barang> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Jaringan Error! " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void kondisi(String kond) {

        if (kond == null) {

            btnTambah.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertUser();
                }
            });

        }
    }

}