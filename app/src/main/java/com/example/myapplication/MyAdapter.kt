package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MyAdapter(private val smsList: ArrayList<SMS>, private val onItemClick: (SMS) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val sms = smsList[position]
        // عرض الاسم أو الرقم
        holder.tvSender.text = formatPhoneNumber(sms.sender)

        // عرض الرسالة
        holder.tvBody.text = sms.body

        // عرض الوقت بشكل ذكي
        holder.tvDate.text = formatTime(sms.date)

        // لون عشوائي للـ Avatar
        holder.ivAvatar.setBackgroundColor(getRandomColor())

        holder.itemView.setOnClickListener {
            onItemClick(sms)
        }

    }

    override fun getItemCount(): Int {
        return smsList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSender: TextView = itemView.findViewById(R.id.tvSender)
        val tvBody: TextView = itemView.findViewById(R.id.tvBody)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val ivAvatar: ShapeableImageView = itemView.findViewById(R.id.ivAvatar)

    }


    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    private fun formatPhoneNumber(phone: String): String {
        return if (phone.length > 10) {
            phone.replace(Regex("(\\d{3})(\\d{4})(\\d{4})"), "$1 $2 $3")
        } else {
            phone
        }
    }

    private fun formatTime(timestamp: Long): String {
        val now = Calendar.getInstance()
        val messageTime = Calendar.getInstance().apply {
            timeInMillis = timestamp
        }

        return when {
            // نفس اليوم
            now.get(Calendar.YEAR) == messageTime.get(Calendar.YEAR) &&
                    now.get(Calendar.DAY_OF_YEAR) == messageTime.get(Calendar.DAY_OF_YEAR) -> {
                SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(timestamp))
            }
            // أمس
            now.get(Calendar.YEAR) == messageTime.get(Calendar.YEAR) &&
                    now.get(Calendar.DAY_OF_YEAR) - messageTime.get(Calendar.DAY_OF_YEAR) == 1 -> {
                "Yesterday"
            }
            // هذا الأسبوع
            now.get(Calendar.WEEK_OF_YEAR) == messageTime.get(Calendar.WEEK_OF_YEAR) -> {
                SimpleDateFormat("EEEE", Locale.getDefault()).format(Date(timestamp))
            }
            // هذه السنة
            now.get(Calendar.YEAR) == messageTime.get(Calendar.YEAR) -> {
                SimpleDateFormat("dd MMM", Locale.getDefault()).format(Date(timestamp))
            }
            // سنة مختلفة
            else -> {
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(timestamp))
            }
        }
    }

    private fun getRandomColor(): Int {
        val colors = listOf(
            "#E91E63", "#9C27B0", "#673AB7", "#3F51B5",
            "#2196F3", "#00BCD4", "#009688", "#4CAF50",
            "#FF9800", "#FF5722", "#795548"
        )
        return Color.parseColor(colors.random())
    }
}