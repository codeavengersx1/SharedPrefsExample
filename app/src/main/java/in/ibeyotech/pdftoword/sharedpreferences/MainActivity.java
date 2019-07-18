package in.ibeyotech.pdftoword.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.txtCount)
    TextView txtCount;

    /*
    * Global Object of SharedPreferences
    * */
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Attach ButterKnife to this Activity
        * */
        ButterKnife.bind(this);

        /*
        * You can always find your SharedPreferences files (aka Bhanda aka XML files)
        * "/" is the root on Linux like C:/ on Windows
        *
        * SharedPreferences Path: /data/data/your_package_name/shared_prefs/key_bhanda_local.xml
        * */

        /*
         * Init the Global Object of SharedPreferences
         * */
        sharedPreferences = getSharedPreferences("key_bhanda_local", Context.MODE_PRIVATE);

        /*
        * Get the last known increment value from SharedPreferences
        * */
        int cachedValue = sharedPreferences.getInt("key_count", 0);
        /*
        * Set it to txtCount
        * */
        txtCount.setText(String.valueOf(cachedValue));
    }

    @OnClick(R.id.fabIncrement)
    void onFabClick()
    {
        String initialCount = txtCount.getText().toString();
        /*
        * Convert String to int
        *
        * #Janmabhar
        * */
        int initialCountInInt = Integer.parseInt(initialCount);

        /*
        * Increment the Value of initialCountInInt by 1 using ++ operator
        * */
        initialCountInInt++;

        /*
        * Convert int to String #Janmabhar
        * */
        String incrementedCount = String.valueOf(initialCountInInt);

        /*
        * Set the Value again on txtCount
        * */
        txtCount.setText(incrementedCount);

        /*
        * Permanently Save incrementedCount #Janmabhar
        * */
        sharedPreferences.edit()
                .putInt("key_count", initialCountInInt)
                .apply();
    }
}
