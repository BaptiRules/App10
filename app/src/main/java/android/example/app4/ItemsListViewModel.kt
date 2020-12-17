package android.example.app4

import androidx.lifecycle.ViewModel
import java.lang.Math.random

class ItemsListViewModel: ViewModel() {

    val items = mutableListOf<Item>()

    init {
        for (i in 0 until 100) {
            val item = Item()
            item.Deutsch = "deutsches wort $i"
            item.Englisch = "englisches wort $i"
        }
    }
}