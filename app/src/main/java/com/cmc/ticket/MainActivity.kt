package com.cmc.ticket

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var orderItemList: MutableList<OrderItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        recyclerView = findViewById(R.id.order_items_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        orderItemList = mutableListOf(
            OrderItem("Mexican Healthy", "1x 25.00 dh", R.drawable.bowl),
            OrderItem("Pizza Margherita", "2x 30.00 dh", R.drawable.pizza),
            OrderItem("Beaf burger ", "2x 30.00 dh", R.drawable.burger),
        )

        orderAdapter = OrderAdapter(this, orderItemList)
        recyclerView.adapter = orderAdapter
    }
}