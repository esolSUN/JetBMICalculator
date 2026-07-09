package com.example.jetbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel: ViewModel() {
    //身長計算用引数
    var height by mutableStateOf("")
    //体重計算用引数
    var weight by mutableStateOf("")
    //BMI計算用引数
    var bmi by mutableStateOf(0f)

    //var isShowDetail by remember { mutableStateOf(false) }



    //bmi (weight[kg])/height[m]**2でBMI数値を計算
    fun calculateBMI(){

        //数値の場合引数をフロート型に変換、その以外の入力、“”や“abc”はNULLに変換
        //単位はcmからMに変換
        //NULLの場合は0fに変換
        val heightNumber = height.toFloatOrNull()?.div(100)?:0f
        //数値の場合引数をフロート型に変換、その以外の入力、“”や“abc”はNULLに変換
        //NULLの場合は0fに変換
        val weightNumber = weight.toFloatOrNull()?:0f
        //身長、体重はともに０以上

        bmi = if (heightNumber > 0f && weightNumber > 0f ){
            //BMI公式で数値計算。
            //無限小数を避けるためroundToIntを利用して小数点以下1桁まで残ります。
            (weightNumber/heightNumber.pow(2)*10).roundToInt()/10f
        } else 0f//error処理
    }
}