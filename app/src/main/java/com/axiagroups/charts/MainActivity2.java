package com.axiagroups.charts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ArrayList<BarEntry> barEntryArrayList_1;
    ArrayList<BarEntry> barEntryArrayList_2;
    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        barChart = findViewById(R.id.barChart);

        barEntryArrayList_1 = new ArrayList();
        barEntryArrayList_2 = new ArrayList();

        barEntryArrayList_1.add(new BarEntry(1f, 50f));
        barEntryArrayList_1.add(new BarEntry(2f, 10f));
        barEntryArrayList_1.add(new BarEntry(3f, 30f));
        barEntryArrayList_1.add(new BarEntry(4f, 100f));
        barEntryArrayList_1.add(new BarEntry(5f, 70f));
        barEntryArrayList_1.add(new BarEntry(6f, 90f));

        barEntryArrayList_2.add(new BarEntry(1f, 50f));
        barEntryArrayList_2.add(new BarEntry(1f, 90f));
        barEntryArrayList_2.add(new BarEntry(2f, 10f));
        barEntryArrayList_2.add(new BarEntry(3f, 30f));
        barEntryArrayList_2.add(new BarEntry(4f, 100f));
        barEntryArrayList_2.add(new BarEntry(5f, 70f));

        BarDataSet barDataSet_1 = new BarDataSet(barEntryArrayList_1, "Achived");
        barDataSet_1.setColor(Color.GREEN);
        BarDataSet barDataSet_2 = new BarDataSet(barEntryArrayList_2, "Target");
        barDataSet_2.setColor(Color.RED);

        ArrayList<String> months = new ArrayList<>();
        months.add("Jan");
        months.add("Feb");
        months.add("Mar");

        BarData barData = new BarData(barDataSet_1, barDataSet_2);
        barChart.setData(barData);

        float barSpace = 0.01f;
        float groupSpace = 0.3f;
        float groupCount = 4.0f;

        barData.setBarWidth(0.17f);

        barChart.getXAxis().mAxisMinimum = 0f;
        barChart.getXAxis().mAxisMaximum = 0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount;
        barChart.groupBars(0f, groupSpace, barSpace);








    }
}