package com.spider.composeapp.data.entity

data class NewsResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<Article>,
)

data class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: Any?,
    val url: String,
    val urlToImage: Any?,
    val publishedAt: String,
    val content: Any?,
)

data class Source(
    val id: String,
    val name: String,
)