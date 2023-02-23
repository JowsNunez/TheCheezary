package jose.nunez.thecheezary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        var btnColdDrinks: Button =findViewById(R.id.cold_drinks_button)

        btnColdDrinks.setOnClickListener{

            var intent: Intent = Intent(this,ProductsActivity::class.java)
            startActivity(intent)


        }

    }
}