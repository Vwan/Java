import UnionFind.DynamicConnectivity;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by wanjia on 2016/12/19.
 */
public class DynamicConnectivityTest {
    @Test
    public void test() throws IOException {
        int n = System.in.read();
        DynamicConnectivity dc = new DynamicConnectivity(n);
        int p = System.in.read();
        int q = System.in.read();
        if(true){
            dc.Union(p,q);
        }
    }
}
