package com.aloha.board_test_lsj.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Page {
    // 페이징 기본값
    private static final int PAGE_NUM = 1;
    private static final int ROWS = 10;
    private static final int COUNT = 10;

    private int page;
    private int rows;
    private int count;
    private int total;

    private int start;
    private int end;
    private int first;
    private int last;

    private int prev;
    private int next;

    private int index;
    
    public Page() {
        this(0);
    }
    public Page(int total) {
        this(PAGE_NUM, total);
    }
    public Page(int page, int total) {
        this(page, ROWS, COUNT, total);
    }
    public Page(int page, int rows, int count, int total) {
        this.page = page;
        this.rows = rows;
        this.count = count;
        this.total = total;
        calc();
    }

    public void setTotal(int total) {
        this.total = total;
        calc();
    }

    public void calc() {
        // 첫 번호
        this.first = 1;
        // 마지막 번호
        this.last = (this.total - 1) / rows + 1;
        // 시작 번호
        this.start = ( (page-1) / count) * count + 1;
        // 끝 번호
        this.end = ( (page-1) / count + 1 ) * count;
        if(this.end > this.last) this.end = this.end = this.last;

        // 이전 번호
        this.prev = this.page - 1;
        // 다음 번호
        this.next = this.page + 1;
        // 데이터 순서 번호
        this.index = (this.page - 1) * this.rows;
    }

}
