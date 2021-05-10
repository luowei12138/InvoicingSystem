package cn.bdqn.common;

import java.util.List;

/**
 * @Package: cn.bdqn.util
 * @Description:
 * @Author hah
 * @Create 2021年04月05日 10时31分01秒
 */
public class PageSupport<T> {

    public PageSupport(){}

    public PageSupport(Integer currentPageNo, Integer totalPageCount, Integer totalRecordCount, List<T> plist) {
        this.currentPageNo = currentPageNo;
        this.totalPageCount = totalPageCount;
        this.totalRecordCount = totalRecordCount;
        this.plist = plist;
    }

    /**
     * @Description:  当前页
     **/
    private Integer currentPageNo;

    /**
     * @Description:  总页数
     **/
    private Integer totalPageCount;
    /**
     * @Description:  总条数
     **/
    private Integer totalRecordCount;
    /**
     * @Description:  分页数据
     **/
    private List<T> plist;

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(Integer totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    }

    public List<T> getPlist() {
        return plist;
    }

    public void setPlist(List<T> plist) {
        this.plist = plist;
    }
    
}
