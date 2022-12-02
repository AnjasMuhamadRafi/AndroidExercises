package kampus.merdeka.androidexercises.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kampus.merdeka.androidexercises.R
import androidx.recyclerview.widget.LinearLayoutManager
import kampus.merdeka.androidexercises.RecyclerView.Adapter.TourAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rv_tour: RecyclerView
    val list = ArrayList<DataTour>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        rv_tour = findViewById(R.id.rv_tour)
        rv_tour.setHasFixedSize(true)

        list.addAll(listTour)
        showRecyclerView()

    }


    private val listTour: ArrayList<DataTour>
        get() {
            val dataName= resources.getStringArray(R.array.data_name)
            val dataDescription= resources.getStringArray(R.array.data_description)
            val dataPhoto= resources.obtainTypedArray(R.array.data_photo)


            val lists = ArrayList<DataTour>()
            for (i in dataName.indices){
                val tour = DataTour(
                    dataName[i],dataDescription[i],dataPhoto.getResourceId(i, -1)
                )
                lists.add(tour)
            }
            return lists
        }

    fun showRecyclerView(){
        rv_tour.layoutManager = LinearLayoutManager(this)
        val TourAdapter = TourAdapter(list)
        rv_tour.adapter = TourAdapter



    }

}

