
package android.example.app4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnLongClickListener{

//VARIABLEN DEFINIEREN

    /*private val Item_list = listOf(
            Item("deutsches wort", "englisches wort", 3),
            Item("Auto", "Car",4),
            Item("Haus", "house",5)
    )*/

    /*private fun generateDummyList(size: Int): ArrayList<Item> {
     val list = ArrayList<Item>()
     for (i in 0 until size) {

         val item = Item("Deutsch - ${i+1}", "Englisch")
         list += item
     }
     return list
 }*/

    val Item_list = mutableListOf<Item>()
    //private val exampleList = generateDummyList(0)
                                                                    //Problem 1
    private val adapter = Adapter(Item_list, this)         //<-- brauche ich für longclick
    private var adapter2: Adapter? = null                        //<--  brauche ich für updateUI



    private val viewmodel: ItemsListViewModel /*by activityViewModels*/()       //Problem 2


    private lateinit var Seite2Button: Button
    private lateinit var listRecyclerView: RecyclerView
    //private lateinit var buttonchange: Button

    private lateinit var text_view_de: TextView
    private lateinit var text_view_en: TextView

    private var currentId = 0


//ONCREATE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    //RECYCLERVIEW
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    //FINDVIEWBYID
        Seite2Button = findViewById(R.id.New_Activity)
        listRecyclerView = findViewById(R.id.recycler_view)
        //buttonchange = findViewById(R.id.button_change)

    //IMPLEMENTRIERUNG

   /* buttonchange.setOnClickListener{
    }*/

    Seite2Button.setOnClickListener {
        val intent = Intent(this, FilesActivity::class.java)
        startActivity(intent)
    }

    /*val questionTextResId = Item_list[currentId].textResId
    text_view_de.setText(questionTextResId)
    text_view_en.setText(questionTextResId)*/

    updateUI()

}


//WEITERE KLASSEN


    private fun updateUI() {
        val items = viewmodel.items
        adapter2 = Adapter(items)
        listRecyclerView.adapter = adapter
    }




    override fun onLongClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = Item_list[position]

        //clickedItem.Deutsch = "Clicked"
        //adapter.notifyItemChanged(position)

        //Item_list.removeAt(position) brauch ich---------------------------------------------------
        adapter?.notifyItemRemoved(position)

    }

    //MENÜ KLASSE
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{

        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.open_menu->{

                val intent = Intent(this, InputActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    /*public fun insertItem(view: Editable) {                             //Das will ich aufrufen und da variable weitergeben
        val a = intent.getStringExtra("inputText1")
        //val a = "kp"
        //val b = InputActivity.inputText1

        val index = 0

        val newItem = Item(
            "de $a",
            "en")

        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)    }*/

}
