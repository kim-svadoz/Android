package multi.android.map_location_pro.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import multi.android.map_location_pro.R;
/*
SupporMapFragment로 부터 지도객체를 추출해야 지도에 여러 가지 작업을 처리할 수 있는데
구글맵은 카메라로 지도를 비추고 있는 형태가 모델링 되어있기 때문에 이 위치를 찾는데 시간이 걸린다.
따라서 내부에서 자동으로 전달될 수 있도록 작업해야한다.(ver.2로 바뀌면서 적용된 내용)
0. FragmentManager를 이용해서 SupportMapFRagment를 find
1. OnMapReadyCallback을 구현하고 onMapReady메소드를 오버라이딩
2. SupportMapFragment객체에 getMapAsync메소드를 이용해서 1번에서 구현한 onMapReadyCallback 객체를 연결
3. 맵이 준비되었을 때 자동으로 onMapReady메소드가 호출되면서 매개변수로 구글맵이 전달된다.

*/

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Map프래그먼트를 추출
        //현재 xml문서에 정의된 Fragment를 추출하는 경우 FragmentManager를 이용해서 추출
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    GoogleMap map;
    MarkerOptions markerOptions; //마커에 대한 정보를 담고 있는 객체
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("mymap","준비완료");
        map = googleMap;
        if(map!=null){
            //위도, 경도를 셋팅
            LatLng myloc = new LatLng(37.5856988,126.9723925);
            //구글맵이 v2가 되면서 카메라개념이 추가
            //지도는 카메라로 아래를 내려다보는 듯한 내용이 모델링
            //변경사항에 관련된 내용을 담고 있는 객체 - CameraUpdate
            //CameraUpdate객체에 변경할 값들을 셋팅해서 매개변수로 전달
            //CameraUpdate객체를 만드는 객체가 CameraUpdateFactory
            //CameraUpdate객체의 여러 메소드를 통해서 CameraUpdate객체를 생성

            //map.moveCamera(CameraUpdateFactory.newLatLng(myloc));
            //map.moveCamera(CameraUpdateFactory.newLatLngZoom(myloc,15));

            //현재 카메라의 정보를 담고 있는 객체
            //target() - 화면에 출력되기 위해서 특정 위치의 중앙으로 이동
            //zoom() - 지도의확대 축소 레벨을 설정
            CameraPosition.Builder builder = new CameraPosition.Builder();
            builder.target(myloc);
            builder.zoom(15);
            CameraPosition position = builder.build();
            map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
        }
    }
    public void setPosition(View view){
        LatLng myloc = new LatLng(37.497895, 127.0303356);
        //카메라가 이동할 때 애니메이션이 적용
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(myloc, 17));
    }
    public void setMarker(View view){
        LatLng myloc = new LatLng(37.497895, 127.0303356);
        markerOptions = new MarkerOptions();
        markerOptions.position(myloc); //마커를 출력할 위치
        markerOptions.title("멀티캠퍼스"); //마커를 클릭했을 때 보여줄 풍선도움말 타이틀
        markerOptions.snippet("IT교육센터"); //풍선도움말 내용(추가텍스트)
        map.addMarker(markerOptions); //마커가 생성되어 map에 추가
    }
    public void addCircle(View view){
        //반경을 반투명한 원으로 표현
        LatLng myloc = new LatLng(37.497895, 127.0303356);
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.strokeWidth(10); // circle의 선 width
        circleOptions.strokeColor(0); // 선 색깔
        circleOptions.fillColor(Color.parseColor("#55FF00FF"));
        circleOptions.center(myloc); //circle의 중심
        circleOptions.radius(100); // 미터단위(반지름)
        map.addCircle(circleOptions);
    }
    public void changeMarker(View view){
        //drawable폴더의 resource로 저장되어 있는 이미지 파일을 Bitmap의 형식으로 읽어오기
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.arrow);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap smallMaker = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMaker));
        map.addMarker(markerOptions);
    }
}
