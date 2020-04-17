package multi.android.material_design_pro2.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardViewExam extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_exam);
        list = findViewById(R.id.card);

        List<CardItem> itemList = new ArrayList<>();

        CardItem[] item = new CardItem[5];

        item[0] = new CardItem("이민호의 신의", R.drawable.lee);
        item[1] = new CardItem("공유의 도깨비", R.drawable.gong);
        item[2] = new CardItem("정우성의 비트", R.drawable.jung);
        item[3] = new CardItem("검색어를 입력하세요", R.drawable.jang);
        item[4] = new CardItem("미안하다 사랑한다", R.drawable.so);

        for(int i=0; i<item.length; i++){
            itemList.add(item[i]);
        }

        CardItemAdapter adapter = new CardItemAdapter(this, R.layout.card_item,
                itemList);
        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 1);
        list.setHasFixedSize(true);

        list.setLayoutManager((manager));
        list.setAdapter(adapter);
    }
}
