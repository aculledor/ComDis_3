package gal.usc.etse.soap.calculator;

import javax.jws.WebService;
import java.util.Arrays;

@WebService(
        endpointInterface = "gal.usc.etse.soap.calculator.Calculator",
        serviceName = "Calculator"
)
public class CalculatorImpl implements Calculator {
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int sub(int a, int b) {
        return a-b;
    }

    @Override
    public int mult(int a, int b) {
        return a*b;
    }

    @Override
    public double div(int a, int b) { return (double)a/(double)b; }

    @Override
    public int pow(int a, int b) {
        int toret = a;
        for (int i = 1; i < b; i++) {
            toret *=a;
        }
        return toret;
    }

    @Override
    public double sqrt(int a) {
        return Math.sqrt((double)a);
    }

    @Override
    public double log(int a) {
        return Math.log((double)a);
    }

    @Override
    public int max(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }

    @Override
    public int min(int[] nums) {
        return Arrays.stream(nums).min().getAsInt();
    }

    @Override
    public double average(int[] nums) {
        return (double)Arrays.stream(nums).sum()/(double)nums.length;
    }

    @Override
    public double median(int[] nums) {
        Arrays.sort(nums);
        if (nums.length % 2 == 0)
            return ((double)nums[nums.length/2] + (double)nums[nums.length/2 - 1])/2;
        return (double) nums[nums.length/2];
    }

    @Override
    public double dev(int[] nums) {
        double toret = 0;
        double average = average(nums);
        for (int i=0; i<nums.length;i++)
        {
            toret += Math.pow(nums[i] - average, 2);
        }
        return Math.sqrt(toret/nums.length);
    }



}
