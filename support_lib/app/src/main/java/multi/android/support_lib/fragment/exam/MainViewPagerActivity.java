package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;

public class MainViewPagerActivity extends AppCompatActivity {
    OneFragment oneFragment = new OneFragment();
    TwoFragment twoFragment = new TwoFragment();
    ThreeFragment threeFragment = new ThreeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("one");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("two");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment("three");
            }
        });
    }

    public void setFragment(String name){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (name){
            case "one":
                transaction.replace(R.id.container, oneFragment);
                break;
            case "two":
                transaction.replace(R.id.container, twoFragment);
                break;
            case "three":
                transaction.replace(R.id.container, threeFragment);
        }
        transaction.commit();
    }
}
