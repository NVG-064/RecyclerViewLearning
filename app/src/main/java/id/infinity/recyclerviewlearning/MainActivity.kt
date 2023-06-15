package id.infinity.recyclerviewlearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.infinity.recyclerviewlearning.adapter.TourListAdapter
import id.infinity.recyclerviewlearning.data.Tour
import id.infinity.recyclerviewlearning.databinding.ActivityMainBinding

/**
 * ViewBinding supported
 */
class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  private var tourData = ArrayList<Tour>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.tourRecyclerView.setHasFixedSize(true)

    // Add all data to onCreate() and show the RecyclerView
    tourData.addAll(tourList)
    showRecyclerView()
  }

  /**
   * Generate the data from the resources
   * You can use it with Retrofit
   */
  private val tourList: ArrayList<Tour>
    get() {
      val dataTitle = resources.getStringArray(R.array.data_name)
      val dataDesc = resources.getStringArray(R.array.data_description)
      val dataImage = resources.obtainTypedArray(R.array.data_photo)

      val dataList = ArrayList<Tour>()

      for (i in dataTitle.indices) {
        val tour = Tour(
          dataTitle[i],
          dataDesc[i],
          dataImage.getResourceId(i, -1)
        )
        dataList.add(tour)
      }

      return dataList
    }

  /**
   * To show the RecyclerView
   */
  private fun showRecyclerView() {
    binding.tourRecyclerView.layoutManager = LinearLayoutManager(this)
    binding.tourRecyclerView.adapter = TourListAdapter(tourData)
  }
}