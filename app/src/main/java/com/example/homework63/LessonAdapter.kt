package com.example.homework63

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework63.databinding.FragmentLessonBinding
import com.example.homework63.databinding.ItemLessonsBinding

class LessonAdapter(private val data: ArrayList<Lessons>) : RecyclerView.Adapter<LessonAdapter.LessonHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        return LessonHolder(ItemLessonsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size


   inner  class LessonHolder(private val binding: ItemLessonsBinding) :
       RecyclerView.ViewHolder(binding.root) {

       fun bind(lessons: Lessons) {
           if (lessons.color != null) {
               binding.mainLayout.setBackgroundColor(itemView.context.getColor(lessons.color!!))
           }
           binding.textView.text = lessons.lessonName
           Glide.with(binding.imageView).load(lessons.lessonImage).into(binding.imageView)
           if (lessons.textColor != null){
               binding.textView.setBackgroundColor(itemView.context.getColor(lessons.textColor!!))
           }
       }
    }
}