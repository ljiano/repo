/**
 * Created by jb.liang on 2017/6/22.
 */
public class Page {

    /**
     * 总数据条数
     */
    private int allCount;

    /**
     * 总页码数
     */
    private int pageNum;

    /**
     * 每页显示数量
     */
    private int pageSize;

    /**
     * 当前所在页，第一页开始计数
     */
    private int pageNow;

    public Page(int allCount, int pageSize, int pageNow){
        this.allCount = allCount;
        this.pageSize = pageSize;
        this.pageNow = pageNow;
        if(pageSize == 0){
            return; // 每页显示 0 不合法
        }
        /**
         * 计算总页码数
         * 取余
         * 1：可以整除，则页码总数等于 allCount/pageSize
         * 2：不能整除，则页码总数等于 allCount/pageSize + 1  （java中整型除以整型等于整型）
         */
        pageNum = allCount / pageSize;
        if((allCount % pageSize) != 0){
            pageNum += 1;
        }
    }

    /**
     * 获取 mysql where条件  ：limit  n1, n2（n1:从第几条数据开始， n2:取几条数据 = pageSize）, mysql从第0条开始计数
     * n1: 当前页的第一条数据
     * n2：当前页的最后一条数据
     * @return
     */
    public String autoLimitTo(){
        StringBuilder limitTo = new StringBuilder(" limit ");
        //第一页开始计数，页面上从第一页开始，这里也从第一页开始算（也可以是0，得另外处理）
        int n1 = 0;
        int n2 = pageSize;
        if(pageNow == 0) {
            pageNow += 1;
        }
        //非第一页前几页总和 + 1  （此处不用 + 1，因为n1从0 开始计数）
        n1 = (pageNow - 1) * pageSize;
        limitTo.append(n1 + "," + n2 + " ");
        return limitTo.toString();
    }

    public int getAllCount() {
        return allCount;
    }

    public void setAllCount(int allCount) {
        this.allCount = allCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }
}
