package multi.android.material_design_pro2.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView circlelist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        circlelist = findViewById(R.id.circleRecycler);

        List<CircleItem> itemList = new ArrayList<>();

        CircleItem[] item = new CircleItem[5];
        item[0] = new CircleItem(R.drawable.jang);
        item[1] = new CircleItem(R.drawable.gong);
        item[2] = new CircleItem(R.drawable.jung);
        item[3] = new CircleItem(R.drawable.lee);
        item[4] = new CircleItem(R.drawable.so);

        for(int i=0; i<item.length; i++){
            itemList.add(item[i]);
        }

        RecyclerCurcleAdapter adapter = new RecyclerCurcleAdapter(this, R.layout.circle_item,
                itemList);
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        circlelist.setLayoutManager((manager));
        circlelist.setAdapter(adapter);
    }
}
