package kampus.merdeka.androidexercises.RecyclerView.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kampus.merdeka.androidexercises.R
import kampus.merdeka.androidexercises.RecyclerView.DataTour

class TourAdapter(private val tour: ArrayList<DataTour>) : RecyclerView.Adapter<TourAdapter.TourViewHolder>(){

    class TourViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val ivPhoto : CircleImageView = itemView.findViewById(R.id.ivPhoto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tour, parent,false)
        return TourViewHolder(view)
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        val (name, description, photo) = tour[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.ivPhoto.setImageResource(photo)

    }

    override fun getItemCount(): Int {
        return tour.size
    }
}

