package com;

import java.util.Date;

public class Message extends ID {

    //in real systems string is not used
    //blob clob
    private String msg;


    private User fromUser;
    private User toUser;

    private Date dateSent;
    private Date dateRead;

    private MessageType messageType;

    private boolean isActive;

    public Message(long id, String msg, User fromUser, User toUser) {
        super(id);
        this.msg = msg;
        this.fromUser = fromUser;
        this.toUser = toUser;

        this.dateSent = new Date();
        this.isActive = true;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public void setDateRead(Date dateRead) {
        this.dateRead = dateRead;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getMsg() {
        return msg;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public Date getDateRead() {
        return dateRead;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Message{" +
                ", msg='" + msg + '\'' +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", dateSent=" + dateSent +
                ", dateRead=" + dateRead +
                ", messageType=" + messageType +
                ", isActive=" + isActive +
                '}';
    }
}