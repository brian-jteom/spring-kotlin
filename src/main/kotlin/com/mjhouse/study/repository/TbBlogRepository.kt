package com.mjhouse.study.repository

import com.mjhouse.study.entity.TbBlog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TbBlogRepository : JpaRepository<TbBlog, Long> {
    fun findByBlogTitle(title: String): TbBlog
}