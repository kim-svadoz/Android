package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView myImg;
    TextView nameView;
    TextView dateView;
    TextView textView;
    CheckBox checkView;

    public ViewHolder(View parentView) {
        this.myImg = parentView.findViewById(R.id.actorImg);
        this.nameView = parentView.findViewById(R.id.txtexam1);
        this.dateView = parentView.findViewById(R.id.txtexam2);
        this.textView = parentView.findViewById(R.id.txtexam3);
        this.checkView = parentView.findViewById(R.id.checkinfo);
    }
}
