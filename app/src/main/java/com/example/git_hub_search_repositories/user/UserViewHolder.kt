package com.example.git_hub_search_repositories.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.git_hub_search_repositories.Repositories
import com.example.git_hub_search_repositories.databinding.UsersCardBinding
import com.squareup.picasso.Picasso

internal class UserViewHolder(
    private val context: Context,
    private val binding: UsersCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repository: Repositories) {
        // TODO: Future - Use assync task to get avatar url in activity and remove form viewHolder
        Picasso.get().load(repository.owner.avatarUrl).into(binding.userImage)

        binding.userName.text = repository.name
        setupListeners(repository)
    }

    private fun setupListeners(repository: Repositories) {
        binding.card.setOnClickListener {
            Toast.makeText(context, "CLICADO", Toast.LENGTH_SHORT).show()
            openBrowser(repository.htmlUrl)
        }

        binding.shareUser.setOnClickListener {
            shareRepositoryLink(repository.htmlUrl)
        }
    }

    private fun openBrowser(urlRepository: String) {
        val openBrowserIntent: Intent = Intent().apply {
            action = Intent.ACTION_WEB_SEARCH
            putExtra(Intent.EXTRA_TEXT, urlRepository)
        }

        startActivity(context, openBrowserIntent, Bundle())
    }

    private fun shareRepositoryLink(urlRepository: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, urlRepository)
            type = Values.intentType
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(context, shareIntent, Bundle())
    }

    private object Values {
        const val intentType = "text/plain"
    }
}