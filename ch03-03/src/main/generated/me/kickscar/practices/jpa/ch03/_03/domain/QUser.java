package me.kickscar.practices.jpa.ch03._03.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1915912771L;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");

    public final EnumPath<GenderType> gender = createEnum("gender", GenderType.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> no = createNumber("no", Long.class);

    public final StringPath password = createString("password");

    public final EnumPath<RoleType> role = createEnum("role", RoleType.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

