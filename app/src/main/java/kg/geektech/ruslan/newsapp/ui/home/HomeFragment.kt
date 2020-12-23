package kg.geektech.ruslan.newsapp.ui.home

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import kg.geektech.ruslan.newsapp.R
import kg.geektech.ruslan.newsapp.core.BaseFragment
import kg.geektech.ruslan.newsapp.data.models.ArticleModel
import kg.geektech.ruslan.newsapp.databinding.HomeFragmentBinding
import kg.geektech.ruslan.newsapp.ui.home.adapter.NewsForYouAdapter
import kg.geektech.ruslan.newsapp.ui.home.view_pager.SectionsPagerAdapter
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel, HomeFragmentBinding>(R.layout.home_fragment) {

    private var sectionsPagerAdapter: SectionsPagerAdapter? = null
    private var newsAdapter: NewsForYouAdapter = NewsForYouAdapter()

    override fun getViewModule(): HomeViewModel = inject<HomeViewModel>().value

    override fun getViewBinding(): HomeFragmentBinding? =
        rootView?.let { HomeFragmentBinding.bind(it) }

    override fun setUpView() {
        setUpViewPager()
        setUpRecycler()
    }

    private fun setUpRecycler() {
        binding?.newsRecycler?.adapter = newsAdapter
    }

    private fun setUpViewPager() {
        sectionsPagerAdapter =
            SectionsPagerAdapter(mutableListOf() ,requireContext(), childFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)
    }

    override fun setUpViewModelObs() {
        subscribeNews()
    }

    private fun subscribeNews() {
        mViewModule?.news?.observe(requireActivity(), Observer {
            sectionsPagerAdapter?.data = mutableListOf(ArticleModel(it), ArticleModel(it), ArticleModel(it))
            sectionsPagerAdapter?.notifyDataSetChanged()

            newsAdapter.data.addAll(it)
            newsAdapter.notifyDataSetChanged()

        })
    }

}