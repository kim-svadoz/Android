package multi.android.among.parents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import multi.android.among.R;

public class Parents extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents);

        list = findViewById(R.id.parents);

        List<ParentsItem> itemList = new ArrayList<>();

        ArrayList<ParentsItem> item = new ArrayList<ParentsItem>();

        item.add(new ParentsItem("자녀 1", R.drawable.user));
        item.add(new ParentsItem("자녀 2", R.drawable.user));
        item.add(new ParentsItem("자녀 3", R.drawable.user));
        item.add(new ParentsItem("자녀 4", R.drawable.user));
        item.add(new ParentsItem("자녀 5", R.drawable.user));

        //ParentsItem[] item = new ParentsItem[5];

        /*item[0] = new ParentsItem("자녀 1", R.drawable.user);
        item[1] = new ParentsItem("자녀 2", R.drawable.user);
        item[2] = new ParentsItem("자녀 3", R.drawable.user);
        item[3] = new ParentsItem("자녀 4", R.drawable.user);
        item[4] = new ParentsItem("자녀 5", R.drawable.user);*/

        for(int i=0; i<item.size(); i++){
            itemList.add(item.get(i));
        }

        ParentsItemAdapter adapter = new ParentsItemAdapter(this, R.layout.farents_item,
                itemList);
        /*LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);*/

        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
        list.setHasFixedSize(true);

        list.setLayoutManager((manager));
        list.setAdapter(adapter);
    }
}
