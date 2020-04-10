package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.audiofx.EnvironmentalReverb;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {
    TextView txt;
    String path;
    boolean permission_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
        txt = findViewById(R.id.fileTxt);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            permission_state = true;
            printToast("권한설정완료.");
        }else{
            permission_state = false;
            printToast("권한설정하세요.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1000);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1000 && grantResults.length>0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                permission_state = true;
                printToast("권한 설정 마무리 완료~");
            }else{
                printToast("권한 설정을 하지 않았으므로 기능을 사용할 수 없습니다.");
            }
        }
    }

    public void saveExternalFileSystem(View v){
        if(permission_state){
            printToast("권한 설정 완료");
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){ //현재 사용가능한 상태~
                printToast("사용 가능");
                File external = Environment.getExternalStorageDirectory();

                // 외부저장소/임의의디렉토리 생성
                //  => 앱을 삭제해도 데이터는 남아있다.
                // String dirPath = external.getAbsolutePath()+"/myApp";

                // 외부저장소/android/data/앱의 패키지 명으로 디렉토리 생성
                //  => 앱 삭제하면 데이터가 같이 삭제된다.
                String dirPath = external.getAbsolutePath();

                String pkg = getPackageName();
                File dir = new File(dirPath+"/android/data/"+pkg);
                //디렉토리가 없으면 생성
                //File dir = new File(dirPath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부저장소 테스트중...");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                printToast("사용 불가능");
            }
        }else{
            printToast("권한 설정좀 하자 좀. 좀 !");
        }

    }

    public void oepnExternalFileSystem(View v){

    }

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
