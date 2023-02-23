package jose.nunez.thecheezary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductsActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        agregaProductos();

        var listView: ListView = findViewById(R.id.listView) as ListView
        var adaptador:AdaptadorProductos = AdaptadorProductos(this,coldDrinks)

        listView.adapter=adaptador





    }

    fun agregaProductos() {
        coldDrinks.add(
            Product(
                "Caramel Frap",
                R.drawable.caramel_frap,
                "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.",
                5.0
            )
        )
        coldDrinks.add(
            Product(
                "Chocolate Frap",
                R.drawable.chocolate_frap,
                "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.",
                6.0
            )
        )
        coldDrinks.add(
            Product(
                "Cold Brew",
                R.drawable.coldbrew,
                "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.",
                3.0
            )
        )
        coldDrinks.add(
            Product(
                "Matcha Latte",
                R.drawable.matcha,
                "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.",
                4.0
            )
        )
        coldDrinks.add(
            Product(
                "Oreo Milkshake",
                R.drawable.oreomilkshake,
                "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.",
                7.0
            )
        )
        coldDrinks.add(
            Product(
                "Peanut Milkshake",
                R.drawable.peanutmilkshake,
                "Vanilla ice cream, mixed with peanut butter and chocolate.",
                7.0
            )
        )

    }

    private class AdaptadorProductos : BaseAdapter {
        var productos = ArrayList<Product>();
        var context: Context? = null

        constructor(context: Context, productos: ArrayList<Product>) : super() {
            this.context = context
            this.productos = productos
        }

        override fun getCount(): Int {
            return productos.size

        }

        override fun getItem(position: Int): Any {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = productos[position]
            var inflador = LayoutInflater.from(context)
            var vista = inflador.inflate(R.layout.producto_view, null)
            var image = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            image.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")



            return vista
        }


    }

}