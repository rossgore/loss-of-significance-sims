public class InputParameterSet {
	
	private double corrBetweenIdeologyAndQuestValue;
	private double onQuestNetworkInfluence;
	private double nonQuestNetworkInfluence;
	private double onQuestStepSignficanceReduction;
	private double ifOnQuestInfluenceOfExtremeAgent;
	private double ifOnQuestInfluenceOfSameIdeologyAgent;
	private double ifOnQuestInfluenceOfViolentAgent;
	
	private double questValueDistributionMean;
	private double questValueDistributionSD;
	
	private double questThresholdDistributionMean;
	private double questThresholdDistributionSD;
	
	private double ideologyValueDistributionMean;
	private double ideologyValueDistributionSD;
	
	
	
	private int numberOfAgents;
	private int numberOfTimeSteps;
	
	private double networkHomophily;
	private double extremeIdeologyThreshold;
	
	public InputParameterSet()
	{
		corrBetweenIdeologyAndQuestValue  = 1.0;
		onQuestNetworkInfluence = 0.10;
		nonQuestNetworkInfluence = 0.025;
		onQuestStepSignficanceReduction = 0.001;
		ifOnQuestInfluenceOfExtremeAgent = 1.0;
		ifOnQuestInfluenceOfSameIdeologyAgent = 1.0;
		ifOnQuestInfluenceOfViolentAgent = 1.0;
		
		questValueDistributionMean = 0.50;
		questValueDistributionSD = 0.15;
		
		questThresholdDistributionMean = 0.75;
		questThresholdDistributionSD = 0.05;
		
		ideologyValueDistributionMean = 0.58;
		ideologyValueDistributionSD = 0.15;
		
		
		numberOfAgents = 750;
		numberOfTimeSteps = 1000;
		
		networkHomophily = 0.8;
		extremeIdeologyThreshold = 0.1;
	}
	
	public InputParameterSet(double pCorrBetweenIdeologyAndQuestValue,
			double pOnQuestNetworkInfluence,
			double pNonQuestNetworkInfluence,
			double pOnQuestStepSignficanceReduction,
			double pIfOnQuestInfluenceOfExtremeAgent,
			double pIfOnQuestInfluenceOfSameIdeologyAgent,
			double pIfOnQuestInfluenceOfViolentAgent,
			double pQuestValueDistributionMean,
			double pQuestValueDistributionSD,
			double pQuestThresholdDistributionMean,
			double pQuestThresholdDistributionSD,
			double pIdeologyValueDistributionMean,
			double pIdeologyValueDistributionSD,
			int pNumberOfAgents,
			int pNmberOfTimeSteps,
			double pNetworkHomophily,
			double pExtremeIdeologyThreshold)
	{
		corrBetweenIdeologyAndQuestValue  = pCorrBetweenIdeologyAndQuestValue;
		onQuestNetworkInfluence = pOnQuestNetworkInfluence;
		nonQuestNetworkInfluence = pNonQuestNetworkInfluence;
		onQuestStepSignficanceReduction = pOnQuestStepSignficanceReduction;
		ifOnQuestInfluenceOfExtremeAgent = pIfOnQuestInfluenceOfExtremeAgent;
		ifOnQuestInfluenceOfSameIdeologyAgent = pIfOnQuestInfluenceOfSameIdeologyAgent;
		ifOnQuestInfluenceOfViolentAgent = pIfOnQuestInfluenceOfViolentAgent;
		
		questValueDistributionMean = pQuestValueDistributionMean;
		questValueDistributionSD = pQuestValueDistributionSD;
		
		questThresholdDistributionMean = pQuestThresholdDistributionMean;
		questThresholdDistributionSD = pQuestThresholdDistributionSD;
		
		ideologyValueDistributionMean = pIdeologyValueDistributionMean;
		ideologyValueDistributionSD = pIdeologyValueDistributionSD;
		
		numberOfAgents = pNumberOfAgents;
		numberOfTimeSteps = pNmberOfTimeSteps;
		
		networkHomophily = pNetworkHomophily;
		extremeIdeologyThreshold = pExtremeIdeologyThreshold;
	}
	
	public double getCorrBetweenIdeologyAndQuestValue() {
		return corrBetweenIdeologyAndQuestValue;
	}
	public void setCorrBetweenIdeologyAndQuestValue(double pCorrBetweenIdeologyAndQuestValue) {
		this.corrBetweenIdeologyAndQuestValue = pCorrBetweenIdeologyAndQuestValue;
	}
	public double getQuestValueDistributionMean() {
		return questValueDistributionMean;
	}
	public void setQuestValueDistributionMean(double pQuestValueDistributionMean) {
		this.questValueDistributionMean = pQuestValueDistributionMean;
	}
	public double getOnQuestNetworkInfluence() {
		return onQuestNetworkInfluence;
	}
	public void setOnQuestNetworkInfluence(double pOnQuestNetworkInfluence) {
		this.onQuestNetworkInfluence = pOnQuestNetworkInfluence;
	}
	public double getNonQuestNetworkInfluence() {
		return nonQuestNetworkInfluence;
	}
	public void setNonQuestNetworkInfluence(double pNonQuestNetworkInfluence) {
		this.nonQuestNetworkInfluence = pNonQuestNetworkInfluence;
	}
	public double getOnQuestStepSignficanceReduction() {
		return onQuestStepSignficanceReduction;
	}
	public void setOnQuestStepSignficanceReduction(double pOnQuestStepSignficanceReduction) {
		this.onQuestStepSignficanceReduction = pOnQuestStepSignficanceReduction;
	}
	public double getIfOnQuestInfluenceOfExtremeAgent() {
		return ifOnQuestInfluenceOfExtremeAgent;
	}
	public void setIfOnQuestInfluenceOfExtremeAgent(double pIfOnQuestInfluenceOfExtremeAgent) {
		this.ifOnQuestInfluenceOfExtremeAgent = pIfOnQuestInfluenceOfExtremeAgent;
	}
	public double getIfOnQuestInfluenceOfSameIdeologyAgent() {
		return ifOnQuestInfluenceOfSameIdeologyAgent;
	}
	public void setIfOnQuestInfluenceOfSameIdeologyAgent(double pIfOnQuestInfluenceOfSameIdeologyAgent) {
		this.ifOnQuestInfluenceOfSameIdeologyAgent = pIfOnQuestInfluenceOfSameIdeologyAgent;
	}
	public double getIfOnQuestInfluenceOfViolentAgent() {
		return ifOnQuestInfluenceOfViolentAgent;
	}
	public void setIfOnQuestInfluenceOfViolentAgent(double pIfOnQuestInfluenceOfViolentAgent) {
		this.ifOnQuestInfluenceOfViolentAgent = pIfOnQuestInfluenceOfViolentAgent;
	}
	public double getQuestValueDistributionSD() {
		return questValueDistributionSD;
	}
	public void setQuestValueDistributionSD(double pQuestValueDistributionSD) {
		this.questValueDistributionSD = pQuestValueDistributionSD;
	}
	public double getQuestThresholdDistributionMean() {
		return questThresholdDistributionMean;
	}
	public void setQuestThresholdDistributionMean(double pQuestThresholdDistributionMean) {
		this.questThresholdDistributionMean = pQuestThresholdDistributionMean;
	}
	public double getQuestThresholdDistributionSD() {
		return questThresholdDistributionSD;
	}
	public void setQuestThresholdDistributionSD(double pQuestThresholdDistributionSD) {
		this.questThresholdDistributionSD = pQuestThresholdDistributionSD;
	}
	public double getIdeologyValueDistributionMean() {
		return ideologyValueDistributionMean;
	}
	public void setIdeologyValueDistributionMean(double pIdeologyValueDistributionMean) {
		this.ideologyValueDistributionMean = pIdeologyValueDistributionMean;
	}
	public double getIdeologyValueDistributionSD() {
		return ideologyValueDistributionSD;
	}
	public void setIdeologyValueDistributionSD(double pIdeologyValueDistributionSD) {
		this.ideologyValueDistributionSD = pIdeologyValueDistributionSD;
	}
	public int getNumberOfAgents() {
		return numberOfAgents;
	}
	public void setNumberOfAgents(int pNumberOfAgents) {
		this.numberOfAgents = pNumberOfAgents;
	}
	public int getNumberOfTimeSteps() {
		return numberOfTimeSteps;
	}
	public void setNumberOfTimeSteps(int pNumberOfTimeSteps) {
		this.numberOfTimeSteps = pNumberOfTimeSteps;
	}
	public double getNetworkHomophily() {
		return networkHomophily;
	}
	public void setNetworkHomophily(double pNetworkHomophily) {
		this.networkHomophily = pNetworkHomophily;
	}
	public double getExtremeIdeologyThreshold() {
		return extremeIdeologyThreshold;
	}
	public void setExtremeIdeologyThreshold(double pExtremeIdeologyThreshold) {
		this.extremeIdeologyThreshold = pExtremeIdeologyThreshold;
	}

}
