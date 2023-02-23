package jose.nunez.thecheezary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        var btnColdDrinks: Button = findViewById(R.id.cold_drinks_button)
        var btnHotDrinks: Button = findViewById(R.id.hot_button)
        var btnSwets: Button = findViewById(R.id.sweets_button)
        var btnSalties: Button = findViewById(R.id.salties_button)

        btnColdDrinks.setOnClickListener {

            var intent: Intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)


        }
        btnHotDrinks.setOnClickListener {

            var intent: Intent = Intent(this, HotdrinksActivity::class.java)
            startActivity(intent)

        }

        btnSwets.setOnClickListener{
            var intent: Intent = Intent(this,SwetsActivity::class.java)
            startActivity(intent)
        }

        btnSalties.setOnClickListener{
            var intent: Intent = Intent(this,SaltiesActivity::class.java)
            startActivity(intent)
        }

    }
}