package com.personaldata.dtu.testgraphui;

/**
 * Created by lyspl on 19-04-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.personaldata.dtu.testgraphui.Custom.DataValueFormatter;
import com.personaldata.dtu.testgraphui.Custom.MyAxisValueFormatter;
import com.personaldata.dtu.testgraphui.Custom.WeekdayAxisValueFormatter;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_pager_list, container, false);



        BarChart barChart = (BarChart) rootView.findViewById(R.id.chart1);

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(1f, 15));
        entries.add(new BarEntry(2f, 26));
        entries.add(new BarEntry(3f, 21));
        entries.add(new BarEntry(4f, 23));
        entries.add(new BarEntry(5f, 45));
        entries.add(new BarEntry(6f, 10));
        entries.add(new BarEntry(7f, 27));

        IValueFormatter test = new DataValueFormatter();

        BarDataSet set = new BarDataSet(entries, "BarDataSet");

        BarData data = new BarData(set);
        data.setValueFormatter(test);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.invalidate(); // refresh



        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setTouchEnabled(false);
        barChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        barChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        barChart.setPinchZoom(false);

        barChart.setDrawGridBackground(false);
        // mChart.setDrawYLabels(false);

        IAxisValueFormatter xAxisFormatter = new WeekdayAxisValueFormatter();

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //font
        //xAxis.setTypeface(mTfLight);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        IAxisValueFormatter custom = new MyAxisValueFormatter();

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawAxisLine(false);

        //leftAxis.setTypeface(mTfLight);
        leftAxis.setLabelCount(8, false);
        leftAxis.setValueFormatter(custom);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        rightAxis.setDrawGridLines(false);
        //rightAxis.setTypeface(mTfLight);
        rightAxis.setLabelCount(8, false);
        rightAxis.setValueFormatter(custom);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        barChart.getLegend().setEnabled(false);



        return rootView;


    }
    public static ScreenSlidePageFragment newInstance(String text) {

        ScreenSlidePageFragment f = new ScreenSlidePageFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    }

