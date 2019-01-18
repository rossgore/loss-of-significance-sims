import java.util.Random;

public class Distribution {
	
	public static long SEED = 42;
	
	private Random rand;
	private double min;
	private double max;
	private double skew;
	private double bias;
	
	public Distribution(double pMin, double pMax, double pSkew, double pBias)
	{
		min = pMin;
		max = pMax;
		skew = pSkew;
		bias = pBias;
		rand = new Random(SEED);
	}

	public double nextSkewedBoundedDouble() {
        double range = max - min;
        double mid = min + range / 2.0;
        double unitGaussian = rand.nextGaussian();
        double biasFactor = Math.exp(bias);
        double retval = mid+(range*(biasFactor/(biasFactor+Math.exp(-unitGaussian/skew))-0.5));
        return retval;
    }

}
