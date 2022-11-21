package com.tistory.onethejay.yumyumbaksa.domain.entity

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "TB_USER")
class UserEntity(
    @Id
    var idx: String?,
    var userId: String?,
    var userPw: String?,
    var userPhone: String?,
    var lastLoginAt: LocalDateTime? = null,
    @CreatedBy
    val createdBy: String,
    @CreatedDate
    val createdAt: LocalDateTime,
    @LastModifiedBy
    val updatedBy: String? = null,
    @LastModifiedDate
    val updatedAt: LocalDateTime? = null,
) {
}