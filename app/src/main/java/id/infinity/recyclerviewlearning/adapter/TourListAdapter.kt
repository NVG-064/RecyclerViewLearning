package id.infinity.recyclerviewlearning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.infinity.recyclerviewlearning.data.Tour
import id.infinity.recyclerviewlearning.databinding.ItemRowTourBinding

/**
 * Adapter with ViewBinding
 */
class TourListAdapter(private val tour: ArrayList<Tour>) : RecyclerView.Adapter<TourListAdapter.TourViewHolder>() {
  class TourViewHolder(binding: ItemRowTourBinding) : RecyclerView.ViewHolder(binding.root) {
    val tourImage = binding.tourImageView
    val tourTitle = binding.tourTitleTextView
    val tourDesc = binding.tourDescriptionTextView
  }

  /**
   * Use ViewBinding instead classic method
   */
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
//    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_tour, parent, false)
    val binding = ItemRowTourBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return TourViewHolder(binding)
  }

  /**
   * Return the result in Int
   * This required for RecyclerView of how
   * much items need to be rendered to layout
   */
  override fun getItemCount(): Int {
    return tour.size
  }

  /**
   * Take care of this function
   * This must be synced with Tour.kt
   */
  override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
    val (title, desc, image) = tour[position]
    holder.tourTitle.text = title
    holder.tourDesc.text = desc
    holder.tourImage.setImageResource(image)
  }
}