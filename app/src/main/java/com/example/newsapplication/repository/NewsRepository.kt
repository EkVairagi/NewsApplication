package com.example.newsapplication.repository

import com.example.newsapplication.api.RetrofitInstances
import com.example.newsapplication.db.ArticleDatabase
import com.example.newsapplication.models.Article

class NewsRepository(val db : ArticleDatabase)
{
    suspend fun getBreakingNews(countryCode:String,pageNumber:Int) =
        RetrofitInstances.api.getBreakingNews(countryCode,pageNumber)

    suspend fun searchNews(searchQuery:String,pageNumber: Int) =
        RetrofitInstances.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article:Article) = db.getArticleDAO().upsert(article)

    fun getSavedNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)

}