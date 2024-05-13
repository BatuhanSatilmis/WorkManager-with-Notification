package com.arvato.batuhansatilmis.workmanager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.work.*
import com.arvato.batuhansatilmis.workmanager.databinding.ActivityMainBinding
import com.arvato.batuhansatilmis.workmanager.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupListeners()
    }


    private fun setupListeners() {
        binding.btnOneTime.setOnClickListener {
            viewModel.startOneTimeWork()
        }
        binding.btnPeriodic.setOnClickListener {
            showSnackbar()
            handler.postDelayed({
                viewModel.startPeriodicWork()
                                },15*60*1000)
        }
    }
    private var snackbarShown = false
    private fun showSnackbar() {
        if(!snackbarShown){
            Snackbar.make(findViewById<ConstraintLayout>(R.id.btnPeriodic), "Periodic prosses is playing!", Snackbar.LENGTH_SHORT)
                .show()
         snackbarShown = true
        }

        }

    }


