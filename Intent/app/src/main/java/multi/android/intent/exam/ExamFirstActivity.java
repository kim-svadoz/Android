package multi.android.intent.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import multi.android.intent.R;

public class ExamFirstActivity extends AppCompatActivity {
    public static final int SECOND_BUTTON = 10;
    EditText name;
    EditText tel;
    Button btn;
    Button btn2;
    TextView result;
    public static final int DATA_INTENT = 0;
    public static final int OBJECTA_INTENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        name = findViewById(R.id.EditText01);
        tel = findViewById(R.id.EditText02);
        btn = findViewById(R.id.Button01);
        btn2 = findViewById(R.id.Button02);
        result = findViewById(R.id.first_return);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //명시적 인텐트
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                intent.putExtra("name", name.getText().toString());
                intent.putExtra("tel", tel.getText().toString());

                startActivityForResult(intent, SECOND_BUTTON);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티에 호출하면서 인테트에 객체를 공유
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                User dto = new User(name.getText().toString(), tel.getText().toString());
                intent.putExtra("dto",dto);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==SECOND_BUTTON && resultCode==RESULT_OK){
            boolean state = intent.getBooleanExtra("chkVal", false);
            if(state){
                result.setText("우수회원설정");
            }
        }
    }
}
