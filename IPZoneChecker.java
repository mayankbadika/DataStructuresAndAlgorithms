package myclass;

/*
    Range of IP addresses were mentioned in the question. It should be declared by us in the code as static itself.
    Zone 1: 0.0.0.0 - 127.255.255.255
    Zone 2: 128.0.0.0 - 191.255.255.255
    Zone 3: 192.0.0.0 - 223.255.255.255
    Zone 4: 224.0.0.0 - 255.255.255.255
    Array of IP addresses were given as strings. Find out to which region zone they belong to. If an IP address does not fall into any region, just put -1 for that.
    Input : ["0.0.0.123","129.234.233.24","256.256.2.1"]
    output : [1,2,-1]
 */

import java.util.ArrayList;
import java.util.List;

public class IPZoneChecker {
    public static void main(String[] args) {
        String[] inputIPs = {"0.0.0.123", "129.234.233.24", "256.256.2.1"};
        List<Integer> output = new ArrayList<>();

        for (String ip : inputIPs) {
            output.add(getZone(ip));
        }

        System.out.println(output); // Output: [1, 2, -1]
    }

    public static int getZone(String ip) {
        String[] octets = ip.split("\\.");

        if (octets.length != 4) return -1;

        int firstOctet = Integer.parseInt(octets[0]);
        int secondOctet = Integer.parseInt(octets[1]);
        int thirdOctet = Integer.parseInt(octets[2]);
        int fourthOctet = Integer.parseInt(octets[3]);

        if (firstOctet < 0 || firstOctet > 255 ||
                secondOctet < 0 || secondOctet > 255 ||
                thirdOctet < 0 || thirdOctet > 255 ||
                fourthOctet < 0 || fourthOctet > 255) {
            return -1; // Invalid IP
        }

        if (firstOctet >= 0 && firstOctet < 128) {
            return 1;
        } else if (firstOctet >= 128 && firstOctet < 192) {
            return 2;
        } else if (firstOctet >= 192 && firstOctet < 224) {
            return 3;
        } else if (firstOctet >= 224 && firstOctet <= 255) {
            return 3;
        }

        return -1;
    }
}
