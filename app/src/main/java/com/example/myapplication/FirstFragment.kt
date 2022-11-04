package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Regression!
    private fun fibonacciFoldDebug(n: Int) =
        (2 until n).fold(1 to 1) { (prev, curr), _ ->
            println("prev=$prev, curr=$curr")
            curr to (prev + curr)
        }.second

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setOnClickListener {
            // Slow the app down
            fibonacciFoldDebug(10000)
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonFirst.setBackgroundColor(Color.GREEN)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}