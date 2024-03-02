package com.example.headapinews

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyAdapater(val context: Activity, val artcilesList: List<Article>):
RecyclerView.Adapter<MyAdapater.MyViewHolder>()

{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapater.MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.geteachitems,parent,false)
        return  MyViewHolder(itemView)
    }

    companion object{
        const val Key="com.example.headapinews.MyAdapter.Key"
    }

    override fun onBindViewHolder(holder: MyAdapater.MyViewHolder, position: Int) {
        val currentItems= artcilesList[position]
        holder.title.text="Title:"+currentItems.title
        holder.author.text="Author Name:" +currentItems.author
        holder.content.text ="Content:"+ currentItems.content
        holder.discription.text ="Discriptions:" +currentItems.description
        holder.published.text = "Published On:" +currentItems.publishedAt
        Picasso.get().load(currentItems.urlToImage).into(holder.image)

    }

    override fun getItemCount(): Int {
       return artcilesList.size


    }
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val content : TextView
        val title: TextView
        val discription : TextView
        val published : TextView
        val source : TextView
        val image : ShapeableImageView
        val author : TextView




        init {
            title =itemView.findViewById(R.id.title)
            content = itemView.findViewById(R.id.content)
            discription= itemView.findViewById(R.id.description)
            published = itemView.findViewById(R.id.published)
            source = itemView.findViewById(R.id.source)
            image = itemView.findViewById(R.id.image)
            author= itemView.findViewById(R.id.author)


        }
    }

}