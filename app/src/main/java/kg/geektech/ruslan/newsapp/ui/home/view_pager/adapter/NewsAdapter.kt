package kg.geektech.ruslan.newsapp.ui.home.view_pager.adapter

import android.view.View
import kg.geektech.ruslan.newsapp.R
import kg.geektech.ruslan.newsapp.core.BaseAdapter
import kg.geektech.ruslan.newsapp.core.loadImage
import kg.geektech.ruslan.newsapp.data.models.Article
import kg.geektech.ruslan.newsapp.databinding.ItemNewsBinding

class NewsAdapter : BaseAdapter<Article>(R.layout.item_news, mutableListOf()){

    override fun onBind(view: View, model: Article) {
        ItemNewsBinding.bind(view).also { binding ->
            model.imageUrl?.let { url -> binding.imageNews.loadImage(url) }
            binding.tvNewsSite.text = model.newsSite
            binding.tvTitle.text = model.title
            binding.tvPublishedAt.text = model.publishedAt
            binding.tvSummary.text = model.summary
            binding.tvUpdatedAt.text = model.updatedAt
        }
    }

}