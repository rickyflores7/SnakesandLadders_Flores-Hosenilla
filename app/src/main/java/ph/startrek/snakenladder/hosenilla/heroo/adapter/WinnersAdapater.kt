package ph.startrek.snakenladder.hosenilla.heroo.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ph.startrek.snakenladder.hosenilla.heroo.databinding.WinnersItemBinding

class WinnersAdapter(private val winners: List<String>) : RecyclerView.Adapter
<WinnersAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: WinnersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(winner: String) {
            binding.winnerName.text = winner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WinnersItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(winners[position])
    }

    override fun getItemCount(): Int = winners.size
}
