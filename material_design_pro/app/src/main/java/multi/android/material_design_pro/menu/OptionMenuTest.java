package multi.android.material_design_pro.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import multi.android.material_design_pro.R;

public class OptionMenuTest extends AppCompatActivity {
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_test);
    }
    //activitiy가 만들어질 때 자동으로 호출되는 메소드 - 이 메소드안에서 메뉴를 생성
    //true만 리턴하면 메뉴를 만든다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //xml로 만든 메뉴를 화면에 출력할 수 있도록 구성하는 객체
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        view = findViewById(R.id.result);
        //코드로 메뉴를 만드는 방법
        /*menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드로 추가 1");
        menu.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "코드로 추가 2");*/
        return true;
    }
    //menu에 이벤트 연결하기
    //option menu의 아이템응ㄹ 선택하면 자동으로 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("menu",item.getItemId()+"");
        int id = item.getItemId();
        String msg = "";
        switch (id){
            case R.id.option_1:
                msg = "첫 번째 메뉴 선택";
                break;
            case R.id.option_2:
                msg = "공유";
                break;
            case R.id.option_3:
                msg = "설정";
        }
        view.setText(msg);;
        return super.onOptionsItemSelected(item);
    }
}
