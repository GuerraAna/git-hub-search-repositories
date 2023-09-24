package com.example.git_hub_search_repositories.user

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.git_hub_search_repositories.Repositories
import com.example.git_hub_search_repositories.databinding.UsersCardBinding

internal class UserAdapter(
    private val context: Context,
    private val repositories: List<Repositories>
) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UsersCardBinding.inflate(inflater, parent, false)

        return UserViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        repositories[position].let { repository ->
            holder.bind(repository)
        }
    }

    override fun getItemCount(): Int = repositories.size
}
