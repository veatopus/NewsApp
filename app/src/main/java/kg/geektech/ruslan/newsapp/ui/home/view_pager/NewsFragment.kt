package kg.geektech.ruslan.newsapp.ui.home.view_pager

import android.view.LayoutInflater
import kg.geektech.ruslan.newsapp.R
import kg.geektech.ruslan.newsapp.core.BaseFragment
import kg.geektech.ruslan.newsapp.data.models.ArticleModel
import kg.geektech.ruslan.newsapp.databinding.NewsFragmentBinding
import kg.geektech.ruslan.newsapp.ui.home.view_pager.adapter.NewsAdapter
import org.koin.android.ext.android.inject

class NewsFragment : BaseFragment<PageViewModel, NewsFragmentBinding>(R.layout.news_fragment) {

    private var adapter: NewsAdapter? = null

    override fun getViewModule(): PageViewModel = inject<PageViewModel>().value

    override fun getViewBinding(): NewsFragmentBinding? = rootView?.let {
        NewsFragmentBinding.bind(
            it
        )
    }

    override fun setUpView() {
        initRecycler()
    }

    override fun setUpViewModelObs() {

    }

    private fun initRecycler() {
        adapter = NewsAdapter()
        adapter!!.data = sectionNumber?.data!!
        binding?.recyclerview?.adapter = adapter
    }

    companion object {
        private var sectionNumber: ArticleModel? = null

        @JvmStatic
        fun newInstance(sectionNumber: ArticleModel?): NewsFragment{
            this.sectionNumber = sectionNumber
            return NewsFragment()
        }
    }

}