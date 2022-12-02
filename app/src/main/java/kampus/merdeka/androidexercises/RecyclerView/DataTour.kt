package kampus.merdeka.androidexercises.RecyclerView

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataTour(
    val name: String,
    val description: String,
    val photo: Int
):Parcelable