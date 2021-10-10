package rob.myappcompany.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.nameInput);
        button = findViewById(R.id.buttonPress);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        Set<String> getName = new HashSet<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getName.add(editText.getText().toString());
                Snackbar.make(view, "Created", BaseTransientBottomBar.LENGTH_LONG ).show();
            }
        });

        getName.add("Ali");
        getName.add("Matheo");
        getName.add("Shahram");
        editor.putStringSet("Name", getName);



        editor.apply();


        SharedPreferences getPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Set<String> getName1 = new HashSet<>();
        Set<String> name = getPreferences.getStringSet("Name", getName1);


        if (!name.isEmpty()){


            textView.setText( name.toString());

        }
    }
}