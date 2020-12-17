package android.example.app4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    private lateinit var input_button : Button

    var  inputText1: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        input_button = findViewById(R.id.input_button)

        input_button.setOnClickListener {
            var inputText1 = editText.text
            text1.text = inputText1

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("$inputText1", inputText1)
            startActivity(intent);      //startet main activity

            //var mActivity: MainActivity? = null
            //MainActivity().insertItem()
            //(mActivity as MainActivity).insertItem()


            /*val intent1 = Intent(this, MainActivity::class.java)
            startActivityForResult(intent1, 2)*/

            val inputText2 = editText2.text
            text2.text = inputText2

        }
    }
}

