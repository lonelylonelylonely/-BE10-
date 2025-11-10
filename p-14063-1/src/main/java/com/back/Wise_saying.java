package com.back;


import com.back.domain.AppContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Wise_saying {
    public int id;
    public String saying;
    public String writer;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;


    public Wise_saying( String content, String author) {

        this.saying = content;
        this.writer = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }



    public void setContent(String content) {
        this.saying = content;
    }

    public String getContent() {
        return this.saying;
    }


    public void setAuthor(String author) {
        this.writer = author;
    }

    public String getAuthor() {
        return this.writer;
    }




    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isNew() {
        return getId() == 0;
    }

    public String getForPrintCreateDate() {
        if (createDate == null) return "";

        return createDate.format(AppContext.forPrintDateTimeFormatter);
    }

    public String getForPrintModifyDate() {
        if (createDate == null) return "";


        return createDate.format(AppContext.forPrintDateTimeFormatter);
    }

}

