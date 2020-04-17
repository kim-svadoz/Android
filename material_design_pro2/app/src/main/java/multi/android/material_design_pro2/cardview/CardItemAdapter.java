package multi.android.material_design_pro2.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import multi.android.material_design_pro2.R;

public class CardItemAdapter
        extends RecyclerView.Adapter<CardItemAdapter.ViewHolder> {
    Context context;
    int row_res_id; // row를 구성하는 layout
    List<CardItem> data; //RecyclerView에 출력될 전체 데이터

    public CardItemAdapter(Context context, int row_res_id, List<CardItem> data) {
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
        ImageView img = holder.img;
        TextView txt_view = holder.txtview;

        txt_view.setText(data.get(position).getText());
        img.setImageResource(data.get(position).getImg());

        txt_view.setOnClickListener(new View.OnClickListener() {
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

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtview;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview = itemView.findViewById(R.id.text);
            img = itemView.findViewById(R.id.image);
        }
    }
}
