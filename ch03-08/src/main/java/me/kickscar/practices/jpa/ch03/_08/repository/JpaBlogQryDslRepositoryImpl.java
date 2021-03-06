package me.kickscar.practices.jpa.ch03._08.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.kickscar.practices.jpa.ch03._08.dto.BlogDto;
import me.kickscar.practices.jpa.ch03._08.dto.QBlogDto;
import me.kickscar.practices.jpa.ch03._08.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static me.kickscar.practices.jpa.ch03._08.domain.QBlog.blog;


public class JpaBlogQryDslRepositoryImpl extends QuerydslRepositorySupport implements JpaBlogQryDslRepository {

    @Autowired
    private JPAQueryFactory queryFactory;

    public JpaBlogQryDslRepositoryImpl() {
        super(Blog.class);
    }

    @Override
    public List<Blog> findAll2() {
        return queryFactory
                .select(blog)
                .from(blog)
                .innerJoin(blog.user)
                .fetchJoin()
                .fetch();
    }

    @Override
    public List<BlogDto> findAll3() {
        return queryFactory
                .select(new QBlogDto(blog.no, blog.name, blog.user.id.as("userId")))
                .from(blog)
                .innerJoin(blog.user)
                .fetch();
    }

}
