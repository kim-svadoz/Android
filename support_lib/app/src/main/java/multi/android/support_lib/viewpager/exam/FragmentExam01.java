package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import multi.android.support_lib.R;

public class FragmentExam01 extends AppCompatActivity {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    ViewPager examPager;
    ExamPagerAdapter adapter = new ExamPagerAdapter(getSupportFragmentManager());
    ViewFragment1 viewFragment1;
    //ViewFragment2 viewFragment2;
    ListFragmentTest viewFragment2;
    ViewFragment3 viewFragment3;
    ViewFragment4 viewFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        examPager = findViewById(R.id.examPager);
        setupViewPager(examPager);
        examPager.addOnPageChangeListener(new PageListener());

        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListFragmentTest();
        viewFragment3 = new ViewFragment3();
        viewFragment4 = new ViewFragment4();

    }

    public void setupViewPager(ViewPager viewPager){
        adapter.addFragment(new ViewFragment1(), "첫번째 뷰");
        adapter.addFragment(new ListFragmentTest(), "두번째 뷰");
        adapter.addFragment(new ViewFragment3(), "세번째 뷰");
        adapter.addFragment(new ViewFragment4(), "네번째 뷰");
        viewPager.setAdapter(adapter);
    }

    public void btn_click(View view){
        examPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }

    class ExamPagerAdapter extends FragmentPagerAdapter{

        public ExamPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        public void addFragment(Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을 때
            Toast.makeText(FragmentExam01.this, "페이지가 전환", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
