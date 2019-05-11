package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Member")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MemberEntity {
    /**
     * primary key 로 사용되는 필드에는 `@Id` 어노테이션을 추가합니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private String memberId;

    @Column(name = "token")
    private String token;

    @Column(name = "nickname")
    private String nickname;

    /**
     * CreatedDate 는 엔티티가 생성될 때 자동으로 생성 시각을 입력해줍니다.
     */
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    /**
     * LastModifiedDate 는 엔티티가 갱신될 때 자동으로 갱신 시각을 입력해줍니다.
     */
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
