package ru.smak.vmk_mvvm.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.smak.vmk_mvvm.R
import ru.smak.vmk_mvvm.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    // Model - View - ViewModel (MVVM)

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) {
                viewModel.n = binding.editText.text.toString()

            }
        })
        binding.button3.setOnClickListener{
            onBtnFragmentChangeClick(it)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.res.observe(this.viewLifecycleOwner){
            binding.message.setText(it.toString())
        }
    }

    fun onBtnFragmentChangeClick(view: View){
        activity?.apply{
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SecondFragment.newInstance())
                .commitNow()
        }
    }

}