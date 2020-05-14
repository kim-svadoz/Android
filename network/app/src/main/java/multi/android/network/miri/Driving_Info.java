package multi.android.network.miri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.network.R;

public class Driving_Info extends AppCompatActivity {
    Button btn_driving_enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving__info);
        btn_driving_enter = findViewById(R.id.driving_enter);

        btn_driving_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Driving_Info.this, Driving.class);
                startActivity(intent);
            }
        });

    }
}
