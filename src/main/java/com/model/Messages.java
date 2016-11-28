package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MESSAGES")
public class Messages extends BaseEntity {
    private long id;
    private String msg;

    private Users fromUser;
    private Users toUser;

    private Date dateSent;
    private Date dateRead;

    private boolean isActive;

    public Messages(String msg, Users fromUser, Users toUser) {
        this.msg = msg;
        this.fromUser = fromUser;
        this.toUser = toUser;

        this.dateSent = new Date();
        this.isActive = true;
    }


    // @ManyToOne
    //@JoinColumn(name = "FROM_USER_ID")

    //@OneToMany(targetEntity = Article.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //public List<Article> getArticles() {
    //    return articles;
    //}

    //@OneToOne
    //@JoinColumn(name = "FROM_USER_ID")
    //public Users getUser() {
    //     return user;
    // }


    @Id
    @SequenceGenerator(name = "MESSAGES_SEQ", sequenceName = "SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MESSAGES_SEQ")
    public Long getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getMsg() {
        return msg;
    }

    @Column(name = "DATE_SENT")
    public Date getDateSent() {
        return dateSent;
    }

    @Column(name = "DATE_READ")
    public Date getDateRead() {
        return dateRead;
    }

    @Column(name = "IS_ACTIVE")
    public boolean isActive() {
        return isActive;
    }

    @ManyToOne
    @JoinColumn(name = "FROM_USER_ID")
    public Users getFromUser() {
        return fromUser;
    }

    @ManyToOne
    @JoinColumn(name = "TO_USER_ID")
    public Users getToUser() {
        return toUser;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setFromUser(Users fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(Users toUser) {
        this.toUser = toUser;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}