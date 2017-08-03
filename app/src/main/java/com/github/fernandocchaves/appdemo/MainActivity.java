package com.github.fernandocchaves.appdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener  {

    private EditText nameTxt;
    private TextView nameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.saveBtn).setOnClickListener(this);

        nameTxt = (EditText) findViewById(R.id.nameTxt);
        nameView = (TextView) findViewById(R.id.nameView);
    }

    @Override
    public void onClick(View view) {
        final String text = nameTxt.getText().toString();

        switch (view.getId()) {
            case R.id.saveBtn:
                Intent intent = ShowTextActivity.newStartIntent(this, text);
                startActivity(intent);
                break;
        }
    }
}
