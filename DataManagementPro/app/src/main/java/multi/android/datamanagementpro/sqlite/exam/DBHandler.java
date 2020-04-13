package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import android.widget.ListView;

public class DBHandler{
    SQLiteDatabase db;
    ExamDBHelper DBHelper;
    Context context;
    ListView list;

    public DBHandler(Context context){
        this.context = context;
        DBHelper = new ExamDBHelper(context);
        db = DBHelper.getWritableDatabase();
    }

    public void insert(String name, int price, int count){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("price",price);
        values.put("count",count);
        db.insert("product", null, values);
    }
}
