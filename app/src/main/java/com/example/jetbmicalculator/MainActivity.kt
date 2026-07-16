package com.example.jetbmicalculator

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.jetbmicalculator.ui.theme.JetBMICalculatorTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Log.d("Test", viewModel.test)
        enableEdgeToEdge()
        setContent {
            JetBMICalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ){
                    //var showDialog by remeber { mutableStateOf(false)}

                    //一番外側の·カラム
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(40.dp)

                    ) {//タイトル
                        Text(
                        text = "BMI CALCULATOR APP8",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                        Spacer(modifier = Modifier.height(30.dp))
                        //LabeledTextField関数を利用し、身長入力場所構築、単位は㎝
                        LabeledTextField(
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it},
                            label = "height(cm)",
                            placeholder = "170",
                            )
                        Spacer(modifier = Modifier.height(30.dp))
                        //LabeledTextField関数を利用し、体重入力場所構築、単位は㎏
                        LabeledTextField(
                            value = viewModel.weight,
                            onValueChange = {viewModel.weight = it},
                            label = "weight(kg)",
                            placeholder = "60",
                            )
                        Spacer(modifier = Modifier.height(30.dp))
                        var isShowDialog by remember { mutableStateOf(false) }


                        //calculateボタン
                        Button(

                            onClick = {
                                //viewModelのcalculateBMI関数を呼び出し
                                viewModel.calculateBMI()
                                if (viewModel.bmi == 0f){
                                    isShowDialog = true
                                }else{
                                    isShowDialog = false
                                }

                            },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFF85F6A)

                            )
                        ) {Text(
                            text = "calculate",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            )
                        }



                        Spacer(modifier = Modifier.height(20.dp))


                        //viewModelクラスbmiを使って、計算結果を表示
                        Text(
                            text = if (viewModel.bmi != 0f){
                                "Your BMI is ${viewModel.bmi}"
                            } else {
                                 "You input is wrong. Have to be Numbers bigger than 0 "
                            },
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )

                        if (isShowDialog){
                            AlertDialog(
                                title = {
                                    Text(text = "ERROR")
                                },
                                text = {
<<<<<<< HEAD
                                    Text(text = "ERROR１")
                                },
                                onDismissRequest = {
                                        isShowDialog = false
=======
                                    Text(text = "ERROR")
                                },
                                onDismissRequest = {
                                        isShowDialog = false,
>>>>>>> origin/master
                                },
                                confirmButton = {
                                    TextButton(
                                        onClick = {
<<<<<<< HEAD
                                            isShowDialog = false
=======
                                            isShowDialog = false,
>>>>>>> origin/master
                                        }
                                    ) {
                                        Text("Confirm")
                                    }
                                }
                            )
                        }
                    }
                }
                }
            }
        }
    }

@Composable
fun LabeledTextField(
    value: String,
    //ユーザーから何が入力された時に実行する動作
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
){
    Column() {
        Text(
            text = label,
            color = Color(0xFFF85F6A),
            fontWeight = FontWeight.Bold,
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            //ユーザーから何が入力された時に実行する動作
            onValueChange = onValueChange,
            //入力ボックスの背景を透明に設定
            colors = TextFieldDefaults.colors(
                focusedContainerColor  = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),
            //入力ボックスの入力されていない場合、事前用意したplaceholder内容を表示
            placeholder = { Text(text = placeholder) },
            //入力ボードを数値ボードに設定
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            //一行で表示、改行ができません
            singleLine = true,
            )
    }
}
