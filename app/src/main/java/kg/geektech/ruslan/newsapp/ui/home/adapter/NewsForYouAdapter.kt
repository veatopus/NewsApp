package kg.geektech.ruslan.newsapp.ui.home.adapter

import android.view.View
import kg.geektech.ruslan.newsapp.R
import kg.geektech.ruslan.newsapp.core.BaseAdapter
import kg.geektech.ruslan.newsapp.core.loadImage
import kg.geektech.ruslan.newsapp.data.models.Article
import kg.geektech.ruslan.newsapp.databinding.ItemNewsForYouBinding

class NewsForYouAdapter : BaseAdapter<Article>(R.layout.item_news_for_you, mutableListOf()) {

    override fun onBind(view: View, model: Article) {
        ItemNewsForYouBinding.bind(view).also { binding ->
            model.imageUrl?.let { url -> binding.imageNews.loadImage(url) }
            binding.tvTitle.text = model.title
            binding.tvPublishedAt.text = model.publishedAt
        }
    }

}