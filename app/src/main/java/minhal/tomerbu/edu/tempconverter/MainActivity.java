package minhal.tomerbu.edu.tempconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    boolean isChanging = false;
    @BindView(R.id.tvCelsiusDot)
    TextView tvCelsiusDot;
    @BindView(R.id.tvCelsius)
    TextView tvCelsius;
    @BindView(R.id.etCelsius)
    EditText etCelsius;
    @BindView(R.id.tvCelsiusUnits)
    TextView tvCelsiusUnits;
    @BindView(R.id.tvFahrenheit)
    TextView tvFahrenheit;
    @BindView(R.id.tvFahrenheitDot)
    TextView tvFahrenheitDot;
    @BindView(R.id.etFahrenheit)
    EditText etFahrenheit;
    @BindView(R.id.tvFahrenheitUnits)
    TextView tvFahrenheitUnits;

    //Edit Texts...


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        etCelsius.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (isChanging) return;
                //get the celsius text from the edit text:
                //editable is like StringBuffer or StringBuilder in JAVA
                String c = etCelsius.getText().toString();

                if (c.isEmpty()) {
                    isChanging = true;
                    etFahrenheit.setText(null);
                    isChanging = false;
                    return;
                }


                try {
                    Double celsius = Double.valueOf(c);

                    Double fahrenheit = celsius * 9.0 / 5 + 32;

                    String f = String.valueOf(fahrenheit);
                    isChanging = true;
                    etFahrenheit.setText(f);
                    isChanging = false;
                } catch (NumberFormatException e) {
                    etCelsius.setError("Numbers Only!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        etFahrenheit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (isChanging) return;
                //get the celsius text from the edit text:
                //editable is like StringBuffer or StringBuilder in JAVA
                String f = etFahrenheit.getText().toString();

                if (f.isEmpty()) {
                    isChanging = true;
                    etFahrenheit.setText(null);
                    isChanging = false;
                    return;
                }


                try {
                    Double fahrenheit = Double.valueOf(f);

                    Double celsius = (fahrenheit - 32) * 5 / 9.;

                    String c = String.valueOf(celsius);
                    isChanging = true;
                    etCelsius.setText(c);
                    isChanging = false;
                } catch (NumberFormatException e) {
                    etFahrenheit.setError("Numbers Only!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
