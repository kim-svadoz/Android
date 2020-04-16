package multi.android.material_design_pro.tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;

public class TabTest2 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    //fragment를 담을 ArrayList
    ArrayList<Fragment> fragmentAraryList = new ArrayList<Fragment>();
    //tab문자열을 담을 ArrayList
    ArrayList<String> tabdatalist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test2);
        tabLayout = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);

        tabLayout.setTabTextColors(Color.CYAN, Color.WHITE);
        for(int i=1; i<=10; i++){
            ChildFragment fragment = new ChildFragment();
            fragment.setTitle("작업중인 프래그먼트:"+i);
            fragmentAraryList.add(fragment);
            tabdatalist.add("탭"+i);
            //tabLayout.addTab(tabLayout.newTab().setText("탭"+i));
        }
        PagerAdapter adapter = new PagerAdater(getSupportFragmentManager(), fragmentAraryList.size());
        pager.setAdapter(adapter);

        //TabLayout과 ViewPager를 연결 - ViewPager의 getPageTitle메소드를 호출해서 탭의 문자열을 셋팅
        tabLayout.setupWithViewPager(pager);
    }
    class PagerAdater extends FragmentPagerAdapter{
        public PagerAdater(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentAraryList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentAraryList.size();
        }

        //뷰페이저와 탭을 연결하기 위해서 탭에 출력될 문자열을 만들어내는 메소드
        //setupWithViewPage메소드 내부에서 탭의 문자열을 출력하기 위해서 호출한다.
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabdatalist.get(position);
        }
    }
}
