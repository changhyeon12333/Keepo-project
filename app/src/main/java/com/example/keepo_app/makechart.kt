package com.example.keepo_app

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_notifications.*

class makechart : AppCompatActivity(){

    class ChartActivity : AppCompatActivity() {

        var isrunning = false

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_notifications)

        }

        inner class ThreadClass : Thread() {
            override fun run() {
                var entries: ArrayList<PieEntry> = ArrayList()
                // Entry 배열 초기값 입력
                entries.add(PieEntry(500f,"좋은자세"))
                entries.add(PieEntry(500f,"다리꼰 자세"))
                entries.add(PieEntry(600f,"허리 굽힌자세"))
                entries.add(PieEntry(400f,"거북목"))
                // 그래프 초기값 설정 변수 가능?

                val colorsItem = ArrayList<Int>()
                for (c in ColorTemplate.VORDIPLOM_COLORS) colorsItem.add(c)
                for (c in ColorTemplate.JOYFUL_COLORS) colorsItem.add(c)
                for (c in ColorTemplate.LIBERTY_COLORS) colorsItem.add(c)
                for (c in ColorTemplate.PASTEL_COLORS) colorsItem.add(c)
                // 색상관련

                val pieDataSet = PieDataSet(entries,"")
                    pieDataSet.apply {
                        colors = colorsItem
                        valueTextColor = Color.BLACK
                        valueTextSize = 16f
                    }
                //상세 설정
                val pieData = PieData(pieDataSet)
                    pichart.apply{
                        data=pieData
                        description.isEnabled =false
                        isRotationEnabled =false
                        centerText = "자세 통계량"
                        setEntryLabelColor(Color.BLACK)
                        animateY(1400, Easing.EaseInOutQuad)
                        animate()
                }
            }
        }
    }




}