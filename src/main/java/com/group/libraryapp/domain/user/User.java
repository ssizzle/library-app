package com.group.libraryapp.domain.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incretement 이므로
    private Long id = null;

    @Column(nullable = false,length = 20) //객체필드와 테이블의 필드를 맵핑한다
    private String name;
    private Integer age;

//    protected User() { //JPA를 사용하기 위해서는 매개변수가 없는 기본 생성자가 꼭 필요함
//    }

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
