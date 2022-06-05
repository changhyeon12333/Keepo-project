package com.example.keepo_app.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.keepo_app.AlarmActivity
import com.example.keepo_app.DashboardActivity
import com.example.keepo_app.MainActivity
import com.example.keepo_app.R
import com.example.keepo_app.databinding.FragmentDashboardBinding
import com.example.keepo_app.ui.home.HomeFragment

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val view = inflater.inflate(R.layout.fragment_dashboard, null)
  //      val sButton = view.findViewById<Button>(R.id.botton_start)

  /*      sButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                //여기
                val intent = Intent(context, DashboardActivity::class.java)
                startActivity(intent)
                // 다른 액티비티에서 전환할 때
                // activity?.finish()
            }
        })*/
        val alarmButton = view.findViewById<Button>(R.id.alarm_button)

        alarmButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                //여기
                val intent = Intent(context, AlarmActivity::class.java)
                startActivity(intent)
                // 다른 액티비티에서 전환할 때
                // activity?.finish()
            }
        })
        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}