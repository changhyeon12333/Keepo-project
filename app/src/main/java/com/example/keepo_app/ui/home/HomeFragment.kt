package com.example.keepo_app.ui.home

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
import com.example.keepo_app.MainActivity
import com.example.keepo_app.R
import com.example.keepo_app.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val view = inflater.inflate(R.layout.fragment_home, null)
        val loginButton = view.findViewById<Button>(R.id.button_disease)
        loginButton.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, HomeActivity::class.java)
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