package com.example.tableview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TableLayout tableLayout;
    ArrayList<ModelClass> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        tableLayout = (TableLayout)findViewById(R.id.tbl_layout);
        addHeaders();

        modelList = new ArrayList<>();
        ModelClass modelClass = new ModelClass();
        modelClass.setcName("today");
        modelClass.setcBrand("PSX");
        modelClass.setcType("Logged In");
        modelList.add(modelClass);

        ModelClass modelClass1 = new ModelClass();
        modelClass1.setcName("Yesterday");
        modelClass1.setcBrand("PSX");
        modelClass1.setcType("Logged Out");
        modelList.add(modelClass1);

        ModelClass modelClass2 = new ModelClass();
        modelClass2.setcName("Yesterday");
        modelClass2.setcBrand("PSX");
        modelClass2.setcType("Logged Out");
        modelList.add(modelClass2);

        addRows();
    }

    public void addHeaders() {

        TableLayout tl = findViewById(R.id.tbl_layout);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());

        //  tr.addView(getTextView(0, "Auditor id", Color.WHITE, Typeface.BOLD, R.color.colorAccent));
        tr.addView(getTextView(0, "InOut Time", Color.BLACK, Typeface.BOLD, R.drawable.cell_shape ));
        tr.addView(getTextView(0, "Longitude,Latitude", Color.BLACK, Typeface.BOLD, R.drawable.cell_shape ));
        tr.addView(getTextView(0, "Remarks", Color.BLACK, Typeface.BOLD, R.drawable.cell_shape ));

        tl.addView(tr, getTblLayoutParams());
    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }


    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(1, 1, 1, 1);
        params.weight = 1;
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onClick(View v) {

    }

    public void addRows(){
        // Collections.reverse(trainScheduleList);
        for (int i = 0; i < modelList.size(); i++) {
            TableRow tr = new TableRow(MainActivity.this);
            tr.setLayoutParams(getLayoutParams());

            tr.addView(getRowsTextView(0, modelList.get(i).getcName(), Color.BLACK, Typeface.NORMAL, R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getcBrand(), Color.BLACK, Typeface.NORMAL ,R.drawable.cell_shape ));
            tr.addView(getRowsTextView(0, modelList.get(i).getcType(), Color.BLACK, Typeface.NORMAL ,R.drawable.cell_shape ));
            tableLayout.addView(tr, getTblLayoutParams());
        }
    }

    private TextView getRowsTextView(int id, String title, int color, int typeface,int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title);
        tv.setTextColor(color);
        tv.setPadding(40, 40, 40, 40);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundResource(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }
}