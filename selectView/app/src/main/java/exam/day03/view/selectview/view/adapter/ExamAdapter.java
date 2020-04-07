package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExamAdapter extends ArrayAdapter {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;

    HashMap<Integer, SaveActorState> saveData = new HashMap<Integer, SaveActorState>();

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);

            //============최초작업이므로 뷰를 찾아서 가져오기=============
            holder = new ViewHolder(convertView);
            //홀더를 저장
            convertView.setTag(holder);
        }else{
            //=============최초 작업이 아니라 뷰를 재사용하는 중이라면============
            holder = (ViewHolder)convertView.getTag();
        }

        ActorItem actor = actorlist.get(position);
        if(actor!=null){
            //위에서 생성한 뷰의 각 요소에 데이터를 연결
            ImageView imageView = holder.myImg;
            TextView nameView = holder.nameView;
            TextView dateView = holder.dateView;
            TextView textView = holder.textView;
            final CheckBox checkView = holder.checkView;

            imageView.setImageResource(actor.myImg);
            nameView.setText(actor.name);
            dateView.setText(actor.date);
            textView.setText(actor.text);

            //뷰를 만들때 저장된 내용이 있는지 체크해서 값을 출력하기
            SaveActorState state = saveData.get(position);
            if(state==null){ // 저장된 객체가 없으면 빈 값을 출력
                checkView.setChecked(false);
            }else{ // 저장된 객체가 있음면 객체에서 data를 추출해서 출력
                checkView.setChecked(state.chkValue);
            }

            checkView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean chkValue = checkView.isChecked();
                    SaveActorState chkstate = new SaveActorState();
                    chkstate.chkValue = chkValue;
                    saveData.put(position, chkstate);
                }
            });



        }
        return convertView;
    }
}
