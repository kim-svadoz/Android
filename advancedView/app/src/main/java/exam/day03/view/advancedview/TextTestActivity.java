package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextTestActivity extends AppCompatActivity {
    //layout페이지에서 사용할 view에 대한 리소스를 가져와야 하므로 변수 선언
    TextView lblinfo;
    EditText txtinfo;
    Button btngetter;
    Button btnsetter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        lblinfo = findViewById(R.id.myinfo);
        txtinfo = findViewById(R.id.mytext);

        btngetter = findViewById(R.id.btnget);
        btnsetter = findViewById(R.id.btnset);

        btngetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = txtinfo.getText()+"";
                lblinfo.setText(msg);
            }
        });

        btnsetter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                txtinfo.setText("가져온 문자열:작업완료");
            }
        });
        //EditText에서 데이터를 입력할 때 마다 이벤트를 발생
        WathcerListener listener = new WathcerListener();
        txtinfo.addTextChangedListener(listener);
    }
    //TextChanged이벤트를 처리하는 리스너 작성
    class WathcerListener implements TextWatcher{
        //문자값이 변경되기 전에 호출
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //문자값이 변경되었을 때 호출
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("watcher", "s:"+s+",start:"+start+",");
            lblinfo.setText("문자열이 변경되고 있습니다......"+s);
        }
        //문자값이 변경된 후에 호출
        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
