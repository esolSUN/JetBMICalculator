package com.example.jetbmicalculator

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
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
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(40.dp)

                    ) {
                        Text(
                        text = "BMI CALCULATOR APP8",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                        Spacer(modifier = Modifier.height(30.dp))
                        PinkLabeledTextField(
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it},
                            label = "height(cm)",
                            placeholder = "170",
                            )
                        Spacer(modifier = Modifier.height(30.dp))
                        PinkLabeledTextField(
                            value = viewModel.weight,
                            onValueChange = {viewModel.weight = it},
                            label = "weight(kg)",
                            placeholder = "60",
                            )
                        Spacer(modifier = Modifier.height(30.dp))

                        //calculate
                        Button(

                            onClick = {
                                viewModel.calculateBMI()
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

                        Text(
                            text = "Your BMI is ${viewModel.bmi}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )






                    }


                }


                }
            }


        }
    }

@Composable
fun PinkLabeledTextField(
    value: String,
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
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedContainerColor  = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
            ),
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,


            )
    }
}
