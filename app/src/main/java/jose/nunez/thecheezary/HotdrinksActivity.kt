package jose.nunez.thecheezary

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class HotdrinksActivity : AppCompatActivity() {
    var hotDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotdrinks)
        agregaProductos()
        var listView: ListView = findViewById(R.id.listView) as ListView
        var adaptador: AdaptadorProductos = AdaptadorProductos(this, hotDrinks)

        listView.adapter = adaptador

    }

    fun agregaProductos() {
        hotDrinks.add(
            Product(
                "Latte",
                R.drawable.latte,
                "Coffee drink made with espresso and steamed milk",
                6.0
            )
        )
        hotDrinks.add(
            Product(
                "Hot chocolate",
                R.drawable.hotchocolate,
                "Heated drink consisting of shaved chocolate, topped with marshmallows.",
                5.0
            )
        )
        hotDrinks.add(
            Product(
                "Espresso",
                R.drawable.espresso,
                "Full-flavored, concentrated form of coffee.",
                4.0
            )
        )
        hotDrinks.add(
            Product(
                "Chai Latte",
                R.drawable.chailatte,
                "Spiced tea concentrate with milk",
                6.0
            )
        )
        hotDrinks.add(
            Product(
                "Capuccino",
                R.drawable.capuccino,
                "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.",
                7.0
            )
        )
        hotDrinks.add(
            Product(
                "American coffee",
                R.drawable.americano,
                "Espresso with hot water",
                2.0
            )
        )

    }


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