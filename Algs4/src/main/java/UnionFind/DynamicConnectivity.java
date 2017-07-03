package UnionFind;

/**
 * Created by wanjia on 2016/12/19.
 */
public class DynamicConnectivity {
    int[] parent;
    byte[] rank;
    int count;
    public DynamicConnectivity(int n){
        if (n <0) throw new IllegalArgumentException();
        count=n;
        parent = new int[n];
        rank=new byte[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public void Union(int p,int q){

    }

    public boolean isConnected(int p, int q){
        return false;
    }

    public void validate(int p){
        int n=parent.length;  // why parent.length might not be equal to count?
        if (p<0 || p>n){
            throw new IndexOutOfBoundsException("index "+p+" is out of bound");
        }
    }

    public boolean find(int p){
        validate(p);
         return true;
    }
}
