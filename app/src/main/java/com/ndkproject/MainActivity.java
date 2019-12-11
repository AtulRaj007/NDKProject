package com.ndkproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        int sum = add(5, 6);
        int sub = substract(8, 6);
        int mul = multiply(9, 2);
        int div = divide(15, 3);

        Log.e("Sum >>", sum + "");
        Log.e("Sub >>", sub + "");
        Log.e("Mul >>", mul + "");
        Log.e("Div >>", div + "");

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native int add(int x, int y);

    public native int substract(int x, int y);

    public native int multiply(int x, int y);

    public native int divide(int x, int y);

}
