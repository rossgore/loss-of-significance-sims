import org.apache.commons.math3.distribution.NormalDistribution;

public class IndividualLossEvent {
	private double distributionMean;
	private double distributionSD;
	private NormalDistribution distribution;
	
	public IndividualLossEvent()
	{
		distributionMean = 0.25;
		distributionSD = 0.05;
		distribution = new NormalDistribution(distributionMean, distributionSD);
		
	}
	
	public IndividualLossEvent(double pDistributionMean,
			double pDistributionSD)
	{
		distributionMean = pDistributionMean;
		distributionSD = pDistributionSD;
		distribution = new NormalDistribution(distributionMean, distributionSD);
	}
	
	public double getLossEventIntensity()
	{
		double sample = distribution.sample();
		sample = Math.min(sample, 1.0);
		sample = Math.max(sample, 0.0);
		return sample;
	}
	
}
