import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


// Travelling is Fun HackerRank
class Result {

    /*
     * Complete the 'connectedCities' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER numCities
     *  2. INTEGER threshold
     *  3. INTEGER_ARRAY originCities
     *  4. INTEGER_ARRAY destinationCities
     */

    public Map<Integer,Integer> map = new HashMap<>(); // tried with even arrays

    public void makeset(int data){
        map.put(data,data);
    }

    public void union(int data1,int data2){
        int n1 = map.get(data1);
        int n2 = map.get(data2);
        //map[n1]=n2;
        map.put(n1,n2);
    }

    public int find(int k){
        if(map.get(k)==k){
            return k;
        }
        //return find(map[k]);
        return find(map.get(k));
    }


    public static List<Integer> connectedCities(int numCities, int threshold, List<Integer> originCities, List<Integer> destinationCities) {
        // Write your code here

        Result obj = new Result();
        int size = originCities.size()-1;
        List<Integer> res = new ArrayList<>();
        int org=0;int des=0;
        for(int i=0;i<=size;i++){
            obj.makeset(originCities.get(i));
            obj.makeset(destinationCities.get(i));
        }

        for(int i=0;i<=size;i++){
            org = originCities.get(i);
            if(org<threshold) continue;
            for(int j=0;j<=destinationCities.size()-1;j++){
                des = destinationCities.get(j);
                if(des<threshold) continue;
                if(threshold==0){
                    obj.union(org,des);
                    continue;
                }
                if(obj.GCD(org,des)>threshold) obj.union(org,des);
            }
        }

        for(int i=0;i<=size;i++){ // Check if the relationship exists with the same parent(i.e road exists)
            if(obj.find(destinationCities.get(i))==obj.find(originCities.get(i))){
                res.add(i, 1);
            }else{
                res.add(i, 0);
            }
        }
        return res;
    }



    public int GCD(int num1,int num2){ // Eucladian Theorem
        if(num2==0){
            return num1;
        }
        return GCD(num2,num1%num2);
    }

}
public class Soultion2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numCities = Integer.parseInt(bufferedReader.readLine().trim());

        int threshold = Integer.parseInt(bufferedReader.readLine().trim());

        int originCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> originCities = new ArrayList<>();

        for (int i = 0; i < originCitiesCount; i++) {
            int originCitiesItem = Integer.parseInt(bufferedReader.readLine().trim());
            originCities.add(originCitiesItem);
        }

        int destinationCitiesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> destinationCities = new ArrayList<>();

        for (int i = 0; i < destinationCitiesCount; i++) {
            int destinationCitiesItem = Integer.parseInt(bufferedReader.readLine().trim());
            destinationCities.add(destinationCitiesItem);
        }

        List<Integer> result = Result.connectedCities(numCities, threshold, originCities, destinationCities);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
