
public class CollectiveLossEvent {
	private int timeStep;
	private double intensity;


	CollectiveLossEvent(int pTimeStep)
	{
		timeStep = pTimeStep;
		intensity = Math.random();
	}
	
	CollectiveLossEvent(int pTimeStep, double pIntensity)
	{
		timeStep = pTimeStep;
		intensity = pIntensity;
	}
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double pIntensity) {
		this.intensity = pIntensity;
	}
	
	public double getIncToQuestValue(double pAgentThreatSuspectibility)
	{
		return Math.sqrt(pAgentThreatSuspectibility*this.intensity);
	}

	public int getTimeStep() {
		return timeStep;
	}

	public void setTimeStep(int pTimeStep) {
		this.timeStep = pTimeStep;
	}

}
