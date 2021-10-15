import java.util.HashMap;

public class gridways {

    public int ways(int m,int n){
        if(m==1&&n==1) return 1;
        if(m==0||n==0) return 0;

        return ways(m-1,n)+ ways(m,n-1);

    }

    public long waysdp(int m,int n){
        HashMap<String,Long> map = new HashMap<>();
        return waysdp(m,n,map);
    }

    public long waysdp(int m,int n,HashMap<String,Long> map){
        String key = m+","+n;
        if(map.get(key)!=null) return map.get(key);

        if(m==1&&n==1) return 1;
        if(m==0||n==0) return 0;

        map.put(key,waysdp(m-1,n,map)+ waysdp(m,n-1,map));
        return map.get(key);

    }

    public static void main(String[] args){
        gridways obj = new gridways();
        //System.out.println(obj.ways(2,3));
        System.out.println(obj.waysdp(18,18));
    }
}
