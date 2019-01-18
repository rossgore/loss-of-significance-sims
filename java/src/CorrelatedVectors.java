import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.CorrelatedRandomVectorGenerator;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.distribution.NormalDistribution;

// Import common PRNG interface and factory class that instantiates the PRNG.

public class CorrelatedVectors {

	private double signficanceValue;
	private double ideologyValue;

	public CorrelatedVectors(NormalDistribution signficanceValueDist, double pCorrelation, boolean violentIdeology)
	{
		double candidateIdeology = 0.0;
		double candidateQuestValue = 0.0;
		if (violentIdeology)
		{
			boolean suitableCorrelatedPair = false;
			double[] randomVector = null;
			while(suitableCorrelatedPair == false)
			{
				RandomGenerator rg = new JDKRandomGenerator();

				// Create a GassianRandomGenerator using rg as its source of randomness
				GaussianRandomGenerator rawGenerator = new GaussianRandomGenerator(rg);
				double c = Math.pow(signficanceValueDist.getStandardDeviation(), 2.0) * pCorrelation;
				double[] mean = {0.0, 0.0};
				double[][] cov = {{Math.pow(signficanceValueDist.getStandardDeviation(), 2.0), c}, 
						{c, Math.pow(signficanceValueDist.getStandardDeviation(), 2.0)}};


				RealMatrix covariance = MatrixUtils.createRealMatrix(cov); 

				CorrelatedRandomVectorGenerator generator = 
						new CorrelatedRandomVectorGenerator(mean, covariance, 1.0e-12 * covariance.getNorm(), rawGenerator);

				randomVector = generator.nextVector();
				candidateIdeology = randomVector[1];
				candidateQuestValue = randomVector[0];
				if (candidateIdeology > 0)
				{
					suitableCorrelatedPair = true;
				}
			}
			
		}
		else
		{
			boolean suitableCorrelatedPair = false;
			double[] randomVector = null;
			while(suitableCorrelatedPair == false)
			{
				RandomGenerator rg = new JDKRandomGenerator();

				// Create a GassianRandomGenerator using rg as its source of randomness
				GaussianRandomGenerator rawGenerator = new GaussianRandomGenerator(rg);
				double c = Math.pow(signficanceValueDist.getStandardDeviation(), 2.0) * (pCorrelation*-1);
				double[] mean = {0.0, 0.0};
				double[][] cov = {{Math.pow(signficanceValueDist.getStandardDeviation(), 2.0), c}, 
						{c, Math.pow(signficanceValueDist.getStandardDeviation(), 2.0)}};


				RealMatrix covariance = MatrixUtils.createRealMatrix(cov); 

				CorrelatedRandomVectorGenerator generator = 
						new CorrelatedRandomVectorGenerator(mean, covariance, 1.0e-12 * covariance.getNorm(), rawGenerator);

				randomVector = generator.nextVector();
				candidateIdeology = randomVector[1];
				candidateQuestValue = randomVector[0];
				if (candidateIdeology < 0)
				{
					suitableCorrelatedPair = true;
				}
			}
		}
		setSignficanceValue(Agent.NEUTRAL + candidateQuestValue);
		setIdeologyValue(Agent.NEUTRAL + candidateIdeology);

	}

	public double getSignficanceValue() {
		return signficanceValue;
	}

	public void setSignficanceValue(double pSignficanceValue) {
		signficanceValue = pSignficanceValue;
	}

	public double getIdeologyValue() {
		return ideologyValue;
	}

	public void setIdeologyValue(double pIdeologyValue) {
		ideologyValue = pIdeologyValue;
	}
}
