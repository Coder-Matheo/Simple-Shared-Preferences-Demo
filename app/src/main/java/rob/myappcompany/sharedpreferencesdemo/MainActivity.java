package rob.myappcompany.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        for (int i = 0; i < 5; i++){
            editor.putString("Name"+i, "Hamnet"+i);
        }


        editor.apply();


        SharedPreferences getPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = "";
        List<String> getName = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            name = getPreferences.getString("Name", "");
            getName.add(name);
        }
        Log.i("Ta", getName.get(0));
        if (!name.equalsIgnoreCase("")){

            Log.i("Tag", name);
            textView.setText(name);

        }
    }
}