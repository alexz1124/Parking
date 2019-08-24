package buu.informatics.s59160129.parking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160129.parking.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var slot1: MyCar = MyCar("rr", "rr", "rr")
    private var slot2: MyCar = MyCar("oo", "oo", "oo")
    private var slot3: MyCar = MyCar("", "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            statusOne.setOnClickListener { checkClick(1) }
            statusTwo.setOnClickListener { checkClick(2) }
            statusThree.setOnClickListener { checkClick(3) }
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
            btnDel.setOnClickListener { deleteSlot(slot1) }
            btnEdit.setOnClickListener { updateSlot(slot1) }
            updateUI(slot1)
        }
    }
    private fun slotTwo() {
        binding.apply {
            btnDel.setOnClickListener { deleteSlot(slot2) }
            btnEdit.setOnClickListener { updateSlot(slot2) }
            updateUI(slot2)
        }
    }
    private fun slotThree() {
        binding.apply {
            btnDel.setOnClickListener { deleteSlot(slot3) }
            btnEdit.setOnClickListener { updateSlot(slot3) }
            updateUI(slot3)
        }
    }

    private fun deleteSlot(slot : MyCar) {
        slot.plate = ""
        slot.brand = ""
        slot.name = ""
        updateUI(slot)
    }

    private fun updateSlot(slot : MyCar) {
        slot.plate = binding.text1.text.toString()
        slot.brand = binding.text2.text.toString()
        slot.name = binding.text3.text.toString()
    }
    private fun updateUI(slot: MyCar){
        binding.text1.setText(slot.plate)
        binding.text2.setText(slot.brand)
        binding.text3.setText(slot.name)
        binding.invalidateAll()
    }
}
