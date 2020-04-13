package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.DBHelper;

public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText nameEdit;
	EditText countEdit;
	EditText priceEdit;
	ListView listview;

	DBHelper dbHelper= new DBHelper(this);
	SQLiteDatabase db ;

	ArrayAdapter<String> arrayAdapter;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		handler = new DBHandler(this);

//		dbHelper = new DBHelper(this);
//		db = dbHelper.getWritableDatabase();

		//DBHandler.open();

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);

		nameEdit = (EditText)findViewById(R.id.edtName);
		priceEdit = (EditText)findViewById(R.id.edtPrice);
		countEdit = (EditText)findViewById(R.id.edtCount);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.btnIns:
//				String name = nameEdit.getText().toString();
//				int price = Integer.parseInt(priceEdit.getText().toString());
//				int count = Integer.parseInt(countEdit.getText().toString());
				handler.insert(nameEdit.getText().toString(),
						Integer.parseInt(priceEdit.getText().toString()), Integer.parseInt(countEdit.getText().toString()));
				break;
			/*case R.id.btnResult:
				handler.select1(textview);
			case R.id.btnResult2:
				handler.select1(textview);
			case R.id.btnSearch:
				handler.search(edtName.getText().toString());*/
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}
}



















