package com.mjhouse.study.controller

import com.mjhouse.study.dto.BlogReq
import com.mjhouse.study.service.BlogService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/blog")
class BlogController(private val blogService: BlogService) {


    @GetMapping("/list-all")
    fun getBlogList(): ResponseEntity<Any> {
        return ResponseEntity.ok(blogService.getListAll())
    }

    @GetMapping("/detail/{blogId}")
    fun getBlogDetail(@PathVariable blogId: Long): ResponseEntity<Any> {
        return ResponseEntity.ok(blogService.getBlogByIdV1(blogId))
    }

    @PostMapping("/create")
    fun postBlog(@RequestBody req: BlogReq): ResponseEntity<Any> {
        return ResponseEntity.ok(blogService.createBlog(req))
    }

    @PutMapping("/update/{blogId}")
    fun putBlog(@RequestBody req: BlogReq): ResponseEntity<Any> {
        return ResponseEntity.ok(blogService.updateBlog(req))
    }
}