package me.kickscar.practices.jpa.ch03._05.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import me.kickscar.practices.jpa.ch03._05.domain.Board;
import me.kickscar.practices.jpa.ch03._05.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class JpaCommentQryDslRepositoryImpl extends QuerydslRepositorySupport implements JpaCommentQryDslRepository {

    @Autowired
    private JPAQueryFactory queryFactory;

    public JpaCommentQryDslRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public void save(Long boardNo, Comment ...comments) {
        EntityManager em = getEntityManager();

        Board board = em.find(Board.class, boardNo);

        for(Comment comment :  comments) {
            em.persist(comment);
            board.getComments().add(comment);
        }
    }
}
