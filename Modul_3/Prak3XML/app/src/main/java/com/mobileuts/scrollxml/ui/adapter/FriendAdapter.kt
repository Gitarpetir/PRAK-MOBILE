package com.mobileuts.scrollxml.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobileuts.scrollxml.databinding.ItemFriendBinding
import com.mobileuts.scrollxml.model.Friend

class FriendAdapter(
    private val listFriend: List<Friend>,
    private val isHorizontal: Boolean = false,
    private val onDetailClick: (Int) -> Unit,
    private val onInstagramClick: (String) -> Unit
) : RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {

    class FriendViewHolder(val binding: ItemFriendBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        if (isHorizontal) {
            val layoutParams = binding.root.layoutParams
            val screenWidth = parent.context.resources.displayMetrics.widthPixels
            layoutParams.width = (screenWidth * 0.8).toInt()
            binding.root.layoutParams = layoutParams
        }

        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = listFriend[position]

        holder.binding.tvFriendName.text = friend.name
        holder.binding.tvFriendDate.text = friend.date
        holder.binding.tvFriendDescription.text = friend.description
        holder.binding.ivFriendProfile.setImageResource(friend.imageResId)

        holder.binding.btnDetail.setOnClickListener { onDetailClick(friend.id) }
        holder.binding.btnInstagram.setOnClickListener { onInstagramClick(friend.instagramUrl) }
    }

    override fun getItemCount(): Int = listFriend.size
}