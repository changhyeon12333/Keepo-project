package com.example.keepo_app

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_notifications.*

class PieChartActivity : AppCompatActivity() {
    private lateinit var pieChart: PieChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showchart)
        pieChart = findViewById(R.id.pichart)
        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val text3 = findViewById<TextView>(R.id.text3)
        val text4 = findViewById<TextView>(R.id.text4)
        val text5 = findViewById<TextView>(R.id.text5)

        initPieChart()

        setDataToPieChart()
        text1.setOnClickListener {
            setDataToPieChart1()
        }
        text2.setOnClickListener {
            setDataToPieChart2()
        }
        text3.setOnClickListener {
            setDataToPieChart3()
        }
        text4.setOnClickListener {
            setDataToPieChart4()
        }
        text5.setOnClickListener {
            setDataToPieChart5()
        }

    }


    private fun initPieChart() {
        pieChart.setUsePercentValues(true)
        pieChart.description.text = ""
        //hollow pie chart
        pieChart.isDrawHoleEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(false)
        //adding padding
        pieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        pieChart.setUsePercentValues(true)
        pieChart.isRotationEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.legend.orientation = Legend.LegendOrientation.VERTICAL
        pieChart.legend.isWordWrapEnabled = true

    }

    private fun setDataToPieChart() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(100f, "Choice Data"))
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#D3D3D3"))


        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
    private fun setDataToPieChart1() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(1.5f, "Good posture"))
        dataEntries.add(PieEntry(1.2f, "Left cross"))
        dataEntries.add(PieEntry(2.1f, "Right cross"))
        dataEntries.add(PieEntry(1.6f, "Lean forward"))
        dataEntries.add(PieEntry(1.2f, "Lean Back"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#00FF80"))
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#DC143C"))
        colors.add(Color.parseColor("#FFB300"))
        colors.add(Color.parseColor("#FFFF00"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
    private fun setDataToPieChart2() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(3.0f, "Good posture"))
        dataEntries.add(PieEntry(0.2f, "Left cross"))


        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#00FF80"))
        colors.add(Color.parseColor("#FF0000"))


        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
    private fun setDataToPieChart3() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(1.1f, "Good posture"))
        dataEntries.add(PieEntry(17f, "Left cross"))
        dataEntries.add(PieEntry(16f, "Right cross"))
        dataEntries.add(PieEntry(1.2f, "Lean Back"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#00FF80"))
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#DC143C"))
        colors.add(Color.parseColor("#FFFF00"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
    private fun setDataToPieChart4() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(1.5f, "Good posture"))
        dataEntries.add(PieEntry(1.2f, "Left cross"))
        dataEntries.add(PieEntry(2.1f, "Right cross"))
        dataEntries.add(PieEntry(33f, "Lean forward"))
        dataEntries.add(PieEntry(30f, "Lean Back"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#00FF80"))
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#DC143C"))
        colors.add(Color.parseColor("#FFB300"))
        colors.add(Color.parseColor("#FFFF00"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
    private fun setDataToPieChart5() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(34f, "Good posture"))
        dataEntries.add(PieEntry(1.3f, "Left cross"))
        dataEntries.add(PieEntry(2.1f, "Right cross"))
        dataEntries.add(PieEntry(1.6f, "Lean forward"))
        dataEntries.add(PieEntry(8.4f, "Lean Back"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#00FF80"))
        colors.add(Color.parseColor("#FF0000"))
        colors.add(Color.parseColor("#DC143C"))
        colors.add(Color.parseColor("#FFB300"))
        colors.add(Color.parseColor("#FFFF00"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)


        //add text in center
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "Your posture"



        pieChart.invalidate()

    }
}