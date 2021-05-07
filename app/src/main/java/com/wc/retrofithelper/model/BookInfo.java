package com.wc.retrofithelper.model;

import java.util.List;

public class BookInfo {

    private Integer total;
    private Integer limit;
    private Integer page;
    private List<SubjectBean> subject;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<SubjectBean> getSubject() {
        return subject;
    }

    public void setSubject(List<SubjectBean> subject) {
        this.subject = subject;
    }

    public static class SubjectBean {
        private String m_id;
        private String img;
        private String name;
        private String director;
        private String star;
        private String quote;
        private Integer order_num;

        public String getM_id() {
            return m_id;
        }

        public void setM_id(String m_id) {
            this.m_id = m_id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public String getQuote() {
            return quote;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        public Integer getOrder_num() {
            return order_num;
        }

        public void setOrder_num(Integer order_num) {
            this.order_num = order_num;
        }
    }
}
