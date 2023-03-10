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

class SwetsActivity : AppCompatActivity() {
    var sweets = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swets)
        agregaProductos()
        var listView: ListView = findViewById(R.id.listView) as ListView
        var adaptador: AdaptadorProductos =
            AdaptadorProductos(this, sweets)

        listView.adapter = adaptador

    }


    fun agregaProductos() {
        sweets.add(
            Product(
                "Blueberry cake",
                R.drawable.blueberrycake,
                "Vanilla cake flavor, topped with cheese topping and blueberries.”",
                6.0
            )
        )
        sweets.add(
            Product(
                "Chocolate cupcake",
                R.drawable.chocolatecupcake,
                "Chocolate cupcakes topped with butter cream and cherries",
                3.0
            )
        )
        sweets.add(
            Product(
                "Lemon tartalette",
                R.drawable.lemontartalette,
                "Pastry shell with a lemon flavored filling",
                4.0
            )
        )
        sweets.add(
            Product(
                "Red Velvet cake",
                R.drawable.redvelvetcake,
                "Soft, moist, buttery cake topped with an easy cream cheese frosting.",
                6.0
            )
        )
        sweets.add(
            Product(
                "Cherry cheesecake",
                R.drawable.strawberrycheesecake,
                "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.",
                7.0
            )
        )
        sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert", 6.0))

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