package com.example.newsapplication.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapplication.R
import com.example.newsapplication.ui.NewsActivity
import com.example.newsapplication.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment: Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel


        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()
            //article.url?.let { loadUrl(it) }

            loadUrl(article.url.toString())

        }

        fab.setOnClickListener {
            article.let { it1 -> viewModel.saveArticle(it1) }
            Snackbar.make(view,"Article Saved Successfully",Snackbar.LENGTH_LONG).show()
        }

    }

}