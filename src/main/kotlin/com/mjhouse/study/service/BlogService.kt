package com.mjhouse.study.service

import com.mjhouse.study.dto.BlogReq
import com.mjhouse.study.entity.TbBlog
import com.mjhouse.study.repository.TbBlogRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BlogService(
    private val tbBlogRepository: TbBlogRepository
) {

    fun createBlog(req: BlogReq): TbBlog {
        val tbBlog = TbBlog(
            blogTitle = req.blogTitle,
            blogContent = req.blogContent
        )
        return tbBlogRepository.save(tbBlog)
    }

    fun updateBlog(req: BlogReq): TbBlog {
        val tbBlog = TbBlog(
            blogId = req.blogId,
            blogTitle = req.blogTitle,
            blogContent = req.blogContent
        )
        return tbBlogRepository.save(tbBlog)
    }

    fun getListAll(): List<TbBlog> {
        return tbBlogRepository.findAll()
    }

    fun getBlogId(blogId: Long): TbBlog {
        return tbBlogRepository.findById(blogId).orElseThrow { Exception("Blog not found with id: $blogId") }
    }

    fun getBlogByIdV1(blogId: Long): TbBlog {
        return tbBlogRepository.findById(blogId).orElseThrow { Exception("Blog not found with id: $blogId") }
    }

    fun getBlogByIdV2(blogId: Long): TbBlog? {
        return tbBlogRepository.findById(blogId).orElse(null)
    }

    fun getBlogByIdV3(blogId: Long): TbBlog {
        return tbBlogRepository.findById(blogId).orElseThrow { Exception("Blog not found with id: $blogId") }
    }
}