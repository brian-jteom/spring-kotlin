package com.mjhouse.study.entity

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_blog")
data class TbBlog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val blogId: Long = 0,

    @Column(nullable = false, length = 100)
    val blogTitle: String,

    @Column(name = "blog_content", nullable = false, length = 100)
    val blogContent: String,

    @CreationTimestamp
    @Column(updatable = false)
    val regDt: LocalDateTime? = null,

    @UpdateTimestamp
    @Column
    val updDt: LocalDateTime? = null

)