package com.example.helloworld;
//Activity의 LifeCycle
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Activity가 생성될 때 자동으로 호출 - (액티비티가 실행 : 1순위)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("onCreate호출");
        Log.d("test","onCreate호출()");

        setContentView(R.layout.view_basic_property);
    }

    //onCreate다음으로 호출되는 메소드 - (액티비티가 실행 : 2순위)
    // (단, pause상태에서 빠져나올 때는 onCreate가 아니라 onStart부터 호출)
    //일시정지 상태에서 빠져나올 때
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","onStrat()호출");
    }

    //onStart다음으로 호출되는 메소드(액티비티가 실행 : 3순위)
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume()호출");
    }

    //일시정지 상태로 바뀔 때 호출되는 메소드
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause()호출");
    }

    //일시정지나 종료 상태로 바뀔 때 onPause다음으로 호출되는 메소드
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop()호출");
    }

    //앱이 종료될 때 호출되는 메소드
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestroy()호출");
    }

    //버튼을 클릭했을 때 실행할 메소드를 정의
    //메소드의 매개변수에 실행할 버튼을 정의
    //Button의 상위인 View타입으로 정의
    public void myclickMethod(View v){
        Toast.makeText(this, "확인버튼이 눌러졌습니다.", Toast.LENGTH_LONG).show();{

        }
    }
    public void mycancleMethod(View v){
        Toast.makeText(this,"취소되었습니다", Toast.LENGTH_LONG).show();{

        }
    }

    public void mydeleteMethod(View v){
        Toast.makeText(this,"삭제되었습니다", Toast.LENGTH_LONG).show();{

        }
    }
}
