package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncExam extends AppCompatActivity {
    TextView textView;
    Button button;
    Button button2;
    ProgressBar progressBar;
    ImageView imageView;
    MyAsyncExam asyncTaskExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);

    }

    public void ck_bt(View view){
        asyncTaskExam = new MyAsyncExam();
        asyncTaskExam.execute(1);
    }

    class MyAsyncExam extends AsyncTask<Integer, Integer, Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            button.setEnabled(false);
            button2.setEnabled(true);
            progressBar.setProgress(0);
            progressBar.setMax(50);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            int cnt =0;
            int num = integers[0]; //1
            for(int i=0; i<50; i++){
                num = i + 1;
                cnt += num;
                //핸들러에게 UI를 변경하는 쓰레드를 전달하며 요청
                SystemClock.sleep(100);
                publishProgress(num);
            }
            return cnt;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.incrementProgressBy(1);
            Log.d("exam","ddd===="+values[0]);
            textView.setText(values[0].toString());
            if(values[0]%2==0){
                imageView.setImageResource(R.drawable.d1);
            }else{
                imageView.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText("Result : "+integer);
            button.setEnabled(true);
            button2.setEnabled(false);
        }
    }
}
