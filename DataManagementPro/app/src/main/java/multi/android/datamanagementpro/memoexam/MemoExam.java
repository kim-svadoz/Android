package multi.android.datamanagementpro.memoexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Date;

import multi.android.datamanagementpro.R;

public class MemoExam extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    EditText txt;
    boolean permission_state;
    String path;
    String dirPath="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_exam);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        txt = findViewById(R.id.edittxt);

        if(checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            permission_state = true;
            printToast("권한설정완료.");
        }else{
            printToast("권한설정하세요.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1000);
        }

    }


    public void save(View v){
        String data = txt.getText().toString();
        if(permission_state){
            String state = Environment.getExternalStorageState();
            if(state.equals(Environment.MEDIA_MOUNTED)){
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                dirPath = external.getAbsolutePath()+"/mynote/";
                File dir = new File(dirPath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = null;
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                SimpleDateFormat simpledate = new SimpleDateFormat("yyyyMMdd");
                String getTime = simpledate.format(date);
                try {
                    printToast(data);
                    fw = new FileWriter(dir+"/"+getTime+"_memo.txt");
                    fw.write(data);
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
            printToast("권한설정해주세요");
        }
    }

    public void open(View v) {
        if(permission_state){
            String oepn_path;
            String state = Environment.getExternalStorageState();
            BufferedReader br = null;
            FileReader fr = null;
            if(state.equals(Environment.MEDIA_MOUNTED)){
                path = Environment.getExternalStorageDirectory().getAbsolutePath();
                try {
                    fr = new FileReader("20200410_memo.txt");
                    br = new BufferedReader(fr);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }else{
                path = Environment.MEDIA_MOUNTED;
            }
        }else{
            printToast("권한설정해주세요");
        }
    }

    public void newFile(View v){

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

    public void printToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    public boolean checkPermission(String permission){
        if(ContextCompat.checkSelfPermission(this,
                permission)== PackageManager.PERMISSION_GRANTED){
            permission_state = true;
            printToast("권한설정완료.");
            return true;
        }else{
            permission_state = false;
            printToast("권한설정하세요.");
            ActivityCompat.requestPermissions(this, new String[]{permission},
                    1000);
            return false;
        }
    }

}

