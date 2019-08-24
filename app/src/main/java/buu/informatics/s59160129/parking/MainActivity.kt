package buu.informatics.s59160129.parking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160129.parking.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var slot1: MyCar = MyCar("", "", "")
    private var slot2: MyCar = MyCar("", "", "")
    private var slot3: MyCar = MyCar("", "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            status_one.setOnClickListener { checkClick(1) }
            status_two.setOnClickListener { checkClick(2) }
            status_three.setOnClickListener { checkClick(3) }
        }
        updateUI(slot1)
//        binding.myCar = slot1
//        binding.myCar = slot2
//        binding.myCar = slot3
    }


    private fun checkClick(slot: Int) {
        when (slot) {
            1 -> slotOne()
            2 -> slotTwo()
            3 -> slotThree()
        }
    }

    private fun slotOne() {
        binding.apply {
            btnDel.setOnClickListener { deleteSlot(slot1,status_one) }
            btnEdit.setOnClickListener { updateSlot(slot1,status_one) }
            updateUI(slot1)
        }
    }

    private fun slotTwo() {
        binding.apply {
            btnDel.setOnClickListener { deleteSlot(slot2,status_two) }
            btnEdit.setOnClickListener { updateSlot(slot2,status_two) }
            updateUI(slot2)
        }
    }

    private fun slotThree() {
        binding.apply {
            btnDel.setOnClickListener { deleteSlot(slot3,status_three) }
            btnEdit.setOnClickListener { updateSlot(slot3,status_three) }
            updateUI(slot3)
        }
    }

    private fun deleteSlot(slot: MyCar,box : TextView) {
        slot.plate = ""
        slot.brand = ""
        slot.name = ""
        box.setText("available")
        box.setBackgroundColor(Color.GREEN)
        updateUI(slot)
    }

    private fun updateSlot(slot: MyCar,box: TextView) {
        binding.apply {
            slot.plate = text1.text.toString()
            slot.brand = text2.text.toString()
            slot.name = text3.text.toString()
            box.setText("busy")
            box.setBackgroundColor(Color.RED)
            updateUI(slot)
        }
    }

    private fun updateUI(slot: MyCar) {
        binding.apply {
            text1.setText(slot.plate)
            text2.setText(slot.brand)
            text3.setText(slot.name)
            invalidateAll()
        }

    }
}
