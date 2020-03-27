package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class TextExam extends AppCompatActivity {
    EditText txtarea1;
    EditText txtarea2;
    EditText inputdata;
    Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_exam);
        txtarea1 = findViewById(R.id.area1);
        txtarea2 = findViewById(R.id.area2);
        inputdata = findViewById(R.id.intputtxt);
        submitbtn = findViewById(R.id.submit);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtarea1.append(inputdata.getText()+"\n");
                txtarea2.append(inputdata.getText()+"\n");
                inputdata.setText("");

            }
        });
    }
}
