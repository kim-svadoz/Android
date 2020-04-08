package multi.android.intent.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamSecondActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    CheckBox member_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);

        txt = findViewById(R.id.exam_result_txt);
        btn = findViewById(R.id.exam_close);
        member_state = findViewById(R.id.member_state);
        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        if(name==null){
            User dto = intent.getParcelableExtra("dto");
            txt.setText(dto.getName()+","+dto.getTelNum());
        }else{
            String tel = intent.getStringExtra("tel");
            txt.setText("입력한 id: "+name+", 입력한 pass: "+tel);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("chkVal", member_state.isChecked());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}