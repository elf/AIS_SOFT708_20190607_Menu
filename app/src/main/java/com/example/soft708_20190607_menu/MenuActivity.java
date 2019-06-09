package com.example.soft708_20190607_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    public static String[] MenuCategories = {"Breakfast", "Lunch", "Dinner"};

    public static String[][][] MenuDetails = {
            {
                    {
                            "Breakfast Bread", "This is description for Breakfast Bread", "NZD10"
                    },
                    {
                            "Apple", "This is description for Apple", "NZD1"
                    },
                    {
                            "Banana", "This is description for Banana", "NZD3"
                    },
            },
            {
                    {
                            "Sandwich", "This is description for Sandwich", "NZD8"
                    },
                    {
                            "Pineapple", "This is description for Pineapple", "NZD5"
                    },
                    {
                            "Sushi", "This is description for Sushi", "NZD10"
                    },
            },
            {
                    {
                            "Steak", "This is description for Breakfast Bread", "NZD30"
                    },
                    {
                            "Beef Bowl", "This is description for Apple", "NZD15"
                    },
                    {
                            "Hamburger", "This is description for Banana", "NZD10"
                    },
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("categoryId", 0);
        String[][] menuDetail = MenuDetails[categoryId];

        TableLayout parentLayout = (TableLayout) findViewById(R.id.lotMenuDetails);
        for (int i = 0; i < menuDetail.length; i++) {
            TableRow tblRow = new TableRow(this);
            tblRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));

            TextView menuItemName = new TextView(this);
            TextView menuItemDescription = new TextView(this);
            TextView menuItemPrice = new TextView(this);

            menuItemName.setText(menuDetail[i][0]);
            menuItemDescription.setText(menuDetail[i][1]);
            menuItemPrice.setText(menuDetail[i][2]);

            tblRow.addView(menuItemName);
            tblRow.addView(menuItemDescription);
            tblRow.addView(menuItemPrice);

            parentLayout.addView(tblRow, i);
        }
    }
}
