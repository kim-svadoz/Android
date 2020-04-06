package exam.day03.view.selectview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CheckActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox[] checkArr = new CheckBox[3];
    Switch myswitch ;
    Button showStatus;
    Button setCheckBtn;
    Button clearCheckBtn;
    Button reverseCheckStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        // 뷰의 주소 값을 가지고 온다. - 26버전부터는 캐스팅 클래스를 정의하지 않아도 된다.
        text1 = findViewById(R.id.checkTxt);
        checkArr[0] = findViewById(R.id.check1);
        checkArr[1] = findViewById(R.id.check2);
        checkArr[2] = findViewById(R.id.check3);
        showStatus = findViewById(R.id.btnCheck1);
        setCheckBtn = findViewById(R.id.btnCheck2);
        clearCheckBtn = findViewById(R.id.btnCheck3);
        reverseCheckStats = findViewById(R.id.btnCheck4);

        myswitch = findViewById(R.id.switch1);
        CheckBoxListener listener = new CheckBoxListener();
        // 체크박스에 리스너를 설정한다.
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].setOnCheckedChangeListener(listener);
        }

        myswitch.setOnCheckedChangeListener(listener);
        showStatus.setOnClickListener(listener);
        setCheckBtn.setOnClickListener(listener);
        clearCheckBtn.setOnClickListener(listener);
        reverseCheckStats.setOnClickListener(listener);
    }
    //체크박스들의 상태를 Textview에 출력하기
    public void getCheckStatus(){
        text1.setText("");
        for(int i=0; i<checkArr.length; i++) {
            //isChecked()는 체크박스가 선택되어 있으면 true리턴
            if (checkArr[i].isChecked()) {
                String tag = (String)checkArr[i].getTag();
                text1.append(tag + "번 체크박스가 체크되었습니다.\n");
            }
        }

    }
    //모든 체크박스의 상태를 체크상태로 설정하기
    public void setCheckVal(boolean chkVal){
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].setChecked(chkVal);
        }
    }
    //체크박스가 선택되어 있으면 해제, 해제되어 있으면 선택 ( 반전효과 )
    public void toggle(){
        for(int i=0; i<checkArr.length; i++){
            checkArr[i].toggle();
        }
    }

    class CheckBoxListener
            implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

        CheckBox[] checkArr = new CheckBox[3];
        Switch myswitch;

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnCheck1: setCheckVal(true);
                    break;
                case R.id.btnCheck2: getCheckStatus();
                    break;
                case R.id.btnCheck3: setCheckVal(false);
                    break;
                case R.id.btnCheck4: toggle();
            }

        }

        //체크박스의 상태가 변경될때 호출되는 메소드
       /* @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast myToast;
            if(buttonView.isChecked()){
                if(buttonView.toString().equals("check1")){
                    Toast.makeText(CheckActivity.this, "1번째 체크 선택", Toast.LENGTH_LONG).show();
                }else if(buttonView.toString().equals("check2")){
                    Toast.makeText(CheckActivity.this, "2번째 체크 선택", Toast.LENGTH_LONG).show();
                }else if(buttonView.toString().equals("check3")){
                    Toast.makeText(CheckActivity.this, "3번째 체크 선택", Toast.LENGTH_LONG).show();
                }else {
                    if (buttonView.toString().equals("myswitch")) {
                        Toast.makeText(CheckActivity.this, "switch체크 선택", Toast.LENGTH_LONG).show();
                    }
                }
            }

            Log.d("onCheckedChanged", buttonView.toString()+"::::"+isChecked);
        }*/

        //체크박스의 상태가 변경될때 호출되는 메소드
        //체크박스가 선택되면 Toast로 "000체크박스 선택", 해제되면 "000체크박스 해제"
        //스위치가 선택되면 Toast로 "000스위치 선택", 해제되면 "000스위치 해제"
        public void display(int index, TextView textView, boolean checkState){
            if(checkState){
                textView.setText(index+"번째 체크박스가 선택");
            }else{
                textView.setText(index+"번째 체크박스가 해제");
            }
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Toast myToast;
            String msg;
            String msgCheck;
            String msgNot;
            if(buttonView instanceof CheckBox){
                msg = "";
                //체크되면 TextView에 체크 메시지가 출력
                //display(Integer.parseInt(buttonView.getTag()+""), text1, isChecked);
                if(buttonView.isChecked()){
                    msg=buttonView.getTag()+"번째 체크박스가 선택되었습니다.";
                }else{
                    msg=buttonView.getTag()+"번째 체크박스가 해제되었습니다.";
                }

                Toast.makeText(CheckActivity.this,msg,Toast.LENGTH_SHORT).show();
                Log.d("check","체크박스");
            }else{
                Log.d("check","switch");
                if(buttonView.getId()==R.id.switch1){
                    msg="";
                    if(buttonView.isChecked()){
                        msg = "활성";
                    }else{
                        msg= "비활성";
                    }
                    Toast.makeText(CheckActivity.this,msg,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
