package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_LIKE)
@NamedQueries({
        @NamedQuery(
                name = JpaConst.Q_LIKE_GET_ALL_MINE,
                query = JpaConst.Q_LIKE_GET_ALL_MINE_DEF),
        @NamedQuery(
                name = JpaConst.Q_LIKE_COUNT_ALL_MINE,
                query = JpaConst.Q_LIKE_COUNT_ALL_MINE_DEF)
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Like {

    @Id
    @Column(name = JpaConst.LIKE_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = JpaConst.LIKE_COL_EMP, nullable = false)
    private Employee employee;

    @Column(name = JpaConst.LIKE_COL_REP, nullable = false)
    private Report report;

    @Column(name = JpaConst.LIKE_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = JpaConst.LIKE_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = JpaConst.LIKE_COL_LIKED_FLAG, nullable = false)
    private Integer likedFlag;
}
