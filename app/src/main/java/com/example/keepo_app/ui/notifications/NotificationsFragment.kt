package com.example.keepo_app.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.keepo_app.HomeActivity
import com.example.keepo_app.PieChartActivity
import com.example.keepo_app.R
import com.example.keepo_app.databinding.FragmentNotificationsBinding
import com.github.mikephil.charting.data.PieEntry

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val view = inflater.inflate(R.layout.fragment_notifications, null)
        val loginButton = view.findViewById<Button>(R.id.charbutton)
        loginButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, PieChartActivity::class.java)
                startActivity(intent)
                // 다른 액티비티에서 전환할 때
                // activity?.finish()
            }
        })
        return view

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}