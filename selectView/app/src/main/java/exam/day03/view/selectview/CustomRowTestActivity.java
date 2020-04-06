package exam.day03.view.selectview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CustomRowTestActivity extends AppCompatActivity {
    //1. ListView에 출력할 데이터 - 커스텀row로 리스트뷰를 구성하는 경우
    //                             data를 ArrayList로 정의
    ArrayList<String> datalist = new ArrayList<String>();
    ListView listview;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);
        listview = findViewById(R.id.listView1);
        txt = findViewById(R.id.listTxt);

        datalist.add("데자뷰");
        datalist.add("대장금");
        datalist.add("된장국");
        datalist.add("대자보");
        datalist.add("쿤디판다");

        // 2. Adapter 객체를 선택해서 생성
        // 커스텀디자인을 row로 사용할 것이므로 어떤 뷰에 데이터를 연결할 것인지 설정
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.custrow, R.id.txtcust1,
                datalist);

        // 3. ListView에서 어댑터가 작업할 수 있도록 ListView에 어댑터셋팅
        listview.setAdapter(adapter);

        //이벤트연결
        MyListener listener = new MyListener();
        listview.setOnItemClickListener(listener);
    }
    class MyListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            txt.setText(datalist.get(position));
        }
    }
}
