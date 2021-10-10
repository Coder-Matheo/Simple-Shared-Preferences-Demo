package rob.myappcompany.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Name", "Hamnet");
        editor.apply();


        SharedPreferences getPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = getPreferences.getString("Name", "");
        if (!name.equalsIgnoreCase("")){
            textView.setText(name);
        }
    }
}