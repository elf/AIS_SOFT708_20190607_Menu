package com.example.soft708_20190607_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] btns = new Button[MenuActivity.MenuCategories.length];
        LinearLayout layout = (LinearLayout) findViewById(R.id.lotCategory);
        for (int i = 0; i < MenuActivity.MenuCategories.length; i++) {
            btns[i] = new Button(this);
            btns[i].setText(MenuActivity.MenuCategories[i]);
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ClickCategoryButton((TextView) v);
                }
            });
            layout.addView(btns[i]);
        }
    }

    private void ClickCategoryButton(TextView v) {
        String btnText = v.getText().toString();
        for (int i = 0; i < MenuActivity.MenuCategories.length; i++) {
            if (btnText.equals(MenuActivity.MenuCategories[i])) {
                ChooseCategory(i);
                break;
            }
        }
    }

    private void ChooseCategory(int categoryId)
    {
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra("categoryId", categoryId);
        startActivity(intent);
    }
}
