package multi.android.among.parents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.among.R;

public class ParentsItemAdapter extends RecyclerView.Adapter<ParentsItemAdapter.ViewHolder> {
    Context context;
    int row_res_id; // row를 구성하는 layout
    List<ParentsItem> data; //RecyclerView에 출력될 전체 데이터

    public ParentsItemAdapter(Context context, int row_res_id, List<ParentsItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CircleImageView img = holder.img;
        TextView txt_view = holder.txtview;

        txt_view.setText(data.get(position).getText());
        img.setImageResource(data.get(position).getImg());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "데이터연결완료", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtview;
        CircleImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.farentsitemview);
        }
    }
}
