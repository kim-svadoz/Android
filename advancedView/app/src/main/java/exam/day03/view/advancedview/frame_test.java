package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class frame_test extends AppCompatActivity {
    Button loginbtn;
    Button joinbtn;
    Button detailbtn;
    Button submitlogin;
    Button submitjoin;

    LinearLayout loginview;
    LinearLayout joinview;
    LinearLayout detailview;

    TextView detailtxt2;
    TextView logininfo;
    TextView joininfo;

    EditText join_name;
    EditText join_id;
    EditText join_pass;

    ImageView member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_test);

        loginbtn = findViewById(R.id.loginbtn);
        joinbtn = findViewById(R.id.joinbtn);
        detailbtn = findViewById(R.id.detailbtn);
        submitlogin = findViewById(R.id.submitlogin);
        submitjoin = findViewById(R.id.submitjoin);

        loginview = findViewById(R.id.loginview);
        joinview = findViewById(R.id.joinview);
        detailview = findViewById(R.id.detailview);

        detailtxt2 = findViewById(R.id.detailtxt2);
        logininfo = findViewById(R.id.logininfo);
        joininfo = findViewById(R.id.joininfo);

        join_name = findViewById(R.id.joinedit_name);
        join_id = findViewById(R.id.joinedit_id);
        join_pass = findViewById(R.id.joinedit_pass);

        member = findViewById(R.id.member);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginview.setVisibility(View.VISIBLE);
                joinview.setVisibility(View.INVISIBLE);
                detailview.setVisibility(View.INVISIBLE);
            }
        });

        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinview.setVisibility(View.VISIBLE);
                loginview.setVisibility(View.INVISIBLE);
                detailview.setVisibility(View.INVISIBLE);
            }
        });

        detailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailview.setVisibility(View.VISIBLE);
                joinview.setVisibility(View.INVISIBLE);
                loginview.setVisibility(View.INVISIBLE);
            }
        });

        submitjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joininfo.append("name:"+join_name.getText()+"\n"
                        +"id:"+join_id.getText()+"\n"
                        +"password:"+join_pass.getText());

                join_name.setText("");
                join_id.setText("");
                join_pass.setText("");

            }
        });

    }

    //선생님방식 - myclick에 몰아넣기
    //Button이 클릭될때 호출되는 메소드 => View.OnclickListener의
    //public void onClick(View v)메소드와 동일한 역할
    public void myclick(View v){
        if(v.getId()==R.id.loginbtn){
            loginview.setVisibility(View.VISIBLE);
            joinview.setVisibility(View.INVISIBLE);
            detailview.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.joinbtn){
            joinview.setVisibility(View.VISIBLE);
            loginview.setVisibility(View.INVISIBLE);
            detailview.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.detailbtn){
            detailview.setVisibility(View.VISIBLE);
            joinview.setVisibility(View.INVISIBLE);
            loginview.setVisibility(View.INVISIBLE);
        }
    }
}
