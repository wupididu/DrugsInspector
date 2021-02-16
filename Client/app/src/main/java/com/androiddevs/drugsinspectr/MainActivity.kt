package com.androiddevs.drugsinspectr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.androiddevs.drugsinspectr.db.entities.DrugItem
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.io.IOException
import java.nio.charset.Charset

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein: Kodein by kodein()

    private val factory: DrugsViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, factory).get(DrugViewModel::class.java)

        val item = DrugItem(title = "titledsf", description = "desc", amount = 2, dosage = 23F, id = 2)

        button.setOnClickListener {

            viewModel.insert(item)

        }

        btn_delete.setOnClickListener {
            viewModel.delete(item)
        }
    }


}
