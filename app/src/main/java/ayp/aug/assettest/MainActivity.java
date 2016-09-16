package ayp.aug.assettest;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    protected TextView mTextView;
    protected AssetManager am;
    protected String[] fileName;
    protected String assetPath;
    byte [] buffer;
    String s;

    int size;
    InputStream inputStream;
    private String NAME_FOLDER = "HelloWorld";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.txt_story);

        am = getAssets();

        try {
            fileName = am.list(NAME_FOLDER);
            Log.d(TAG, "Found file : " + fileName.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assetPath = NAME_FOLDER + File.separator + fileName[0];
        try {
            inputStream = am.open(assetPath);
            Log.d(TAG,"TexT : "+am.open(assetPath));
            size = inputStream.available();
            buffer = new byte[size];
            inputStream.read(buffer);
            s = new String(buffer);
            mTextView.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
