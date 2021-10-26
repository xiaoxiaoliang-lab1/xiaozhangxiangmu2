package entity;

import java.util.List;

public class Pagebean<T> {
    private int pagecount; //总记录
    private int pagenum; //总页码
    private List<T>  li; //显示的数据
    private int page; //当前页码
    private int row; //每页记录数


    public Pagebean() {
    }

    public Pagebean(int pagecount, int pagenum, List<T> li, int page, int row) {
        this.pagecount = pagecount;
        this.pagenum = pagenum;
        this.li = li;
        this.page = page;
        this.row = row;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public List<T> getLi() {
        return li;
    }

    public void setLi(List<T> li) {
        this.li = li;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Pagebean{" +
                "pagecount=" + pagecount +
                ", pagenum=" + pagenum +
                ", li=" + li +
                ", page=" + page +
                ", row=" + row +
                '}';
    }
}
