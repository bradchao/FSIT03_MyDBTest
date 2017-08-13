package tw.brad.app.helloworld.mydbtest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHelper = new MyDBHelper(this, "brad", null, 1);
        db = myDBHelper.getReadableDatabase();

    }

    public void insert(View view){

    }
    public void delete(View view){

    }
    public void update(View view){

    }
    public void query(View view){
        // select * from cust
        Cursor cursor = db.query("cust",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String id = cursor.getString(0);
            String cname = cursor.getString(1);
            String tel = cursor.getString(2);
            String birthday = cursor.getString(3);
            Log.i("brad", id+":"+cname+":"+tel+":"+birthday);
        }
    }
}
