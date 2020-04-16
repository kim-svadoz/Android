package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro.R;
import multi.android.material_design_pro.exam.ListFragmentTest;
import multi.android.material_design_pro.exam.ViewFragment1;
import multi.android.material_design_pro.exam.ViewFragment3;

public class TabTest extends AppCompatActivity {
    /*private final List<String> mFragmentTitleList = new ArrayList<>();
    private final List<Fragment> mFragmentList = new ArrayList<>();
    ViewPager examPager;
    ExamPagerAdapter adapter = new ExamPagerAdapter(getSupportFragmentManager());*/
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ViewFragment1 viewFragment1;
    ListFragmentTest viewFragment2;
    ViewFragment3 viewFragment3;
    TabLayout tablayout;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);

        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListFragmentTest();
        viewFragment3 = new ViewFragment3();
        tablayout = findViewById(R.id.mytab);
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //탭 추가
        tablayout.addTab(tablayout.newTab().setText("설정"));

        //처음 실행할 때 보여줄 프래그먼트 지정
        getSupportFragmentManager().beginTransaction().
                replace(R.id.content_container,viewFragment1).commit();
        //탭에 이벤트 연결하기
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //탭이 선택될 때 호출되는 메소드
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition(); // 탭의 순서를 받아오기
                Log.d("tab",pos+"");
                Fragment fragment= null;
                if(pos==0){
                    fragment=viewFragment1;
                }else if(pos==1){
                    fragment=viewFragment2;
                }else if(pos==2){
                    fragment=viewFragment3;
                }
                //탭은 선택할 때 지정된 프래그먼트 객체가 show되도록 연결
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.content_container, fragment).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //BottomNavigationView에 이벤트 연결
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.bottom_item2){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.content_container, viewFragment2).commit();
                }
                return false;
            }
        });
    }
}
