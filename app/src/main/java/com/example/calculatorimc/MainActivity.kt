package com.example.calculatorimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        height1?.doAfterTextChanged { text ->

        }
        weight1?.doOnTextChanged { text, start, before, count ->

        }
        calculate?.setOnClickListener {
            calcularIMC(weight1.text.toString(), height1.text.toString())
        }

    }

    @SuppressLint("SetTextI18n")
    private fun calcularIMC(weight: String, height: String) {
        val weight = weight.toFloatOrNull()
        var height = height.toFloatOrNull()

        if (weight != null && height != null){
            val media: Float = weight / (height * height)


            if (media < 16) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Consulte um especialista."
            }

            if (media >= 16 && media <= 16.9) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar muito abaixo do peso." + "\n" + "Consulte um especialista."
            }

            if (media >= 17 && media <= 18.4) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar abaixo do peso." + "\n" + "Consulte um especialista."
            }

            if (media >= 18.5 && media <= 24.9) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar no peso normal." + "\n" + "Consulte um especialista."
            }

            if (media >= 25 && media <= 29.9) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar acima do peso." + "\n" + "Consulte um especialista."
            }

            if (media >= 30 && media <= 34.9) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar com obesidade grau I." + "\n" + "Consulte um especialista."
            }

            if (media >= 35 && media <= 40) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar com obesidade grau II." + "\n" + "Consulte um especialista."
            }

            if (media > 40) {
                result.text = "Seu IMC é %.2f".format(media) + "\n" + "Você pode estar com obesidade grau III." + "\n" + "Consulte um especialista."
            }

        }

        buttonAC.setOnClickListener {
            result.text = ""
            weight1.setText ("")
            height1.setText ("")
        }

    }
}