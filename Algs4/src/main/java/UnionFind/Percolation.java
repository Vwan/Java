package UnionFind;
/**
 * Created by wanjia on 2017/1/11.
 */
import edu.princeton.cs.algs4.QuickFindUF;
public class Percolation {
    QuickFindUF uf;
    private int size;

    int xyTo1D(int x, int y) {
        return x+size-1+y;
    }

    public Percolation(int n){
        size=n*n;
        uf = new QuickFindUF(size);
    }
  /*  public boolean isFull(int row, int col){
        if(isOpen(row,col)){
          //  uf[row].connected().
        }
        return false;
    }
    */
  /*  public boolean isOpen(int row, int col){
        return (sites[row][col]==1);
    }
    public boolean percolates(){
        return false;
    }
    public void open(int row, int col){
        sites[row][col]=1;
    }
    */
}
