import java.util.ArrayList;

public class InputParameterSet {
	
	private double corrBetweenIdeologyAndQuestValue  = 1.0;
	private double onQuestNetworkInfluence = 0.10;
	private double nonQuestNetworkInfluence = 0.025;
	private double onQuestStepSignficanceReduction = 0.001;
	private double ifOnQuestInfluenceOfExtremeAgent = 1.0;
	private double ifOnQuestInfluenceOfSameIdeologyAgent = 1.0;
	private double ifOnQuestInfluenceOfViolentAgent = 1.0;
	
	private double questValueDistributionMean;
	private double questValueDistributionSD;
	
	private double questThresholdDistributionMean;
	private double questThresholdDistributionSD;
	
	private double ideologyValueDistributionMean;
	private double ideologyValueDistributionSD;
	
	private double threatSuspectibilityDistributionMean;
	private double threatSuspectibilityDistributionSD;
	
	private int numberOfAgents;
	private int numberOfTimeSteps;
	
	private double networkHomophily;
	private double extremeIdeologyThreshold = 0.1;
	
	private ArrayList<CollectiveLossEvent> lossEventList;
	
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
		
		threatSuspectibilityDistributionMean = 0.50;
		threatSuspectibilityDistributionSD = 0.15;
		
		numberOfAgents = 750;
		numberOfTimeSteps = 1000;
		
		networkHomophily = 0.8;
		extremeIdeologyThreshold = 0.1;
		
		lossEventList = new ArrayList<CollectiveLossEvent>();
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
			double pThreatSuspectibilityDistributionMean,
			double pThreatSuspectibilityDistributionSD,
			int pNumberOfAgents,
			int pNmberOfTimeSteps,
			double pNetworkHomophily,
			double pExtremeIdeologyThreshold,
			ArrayList<CollectiveLossEvent> pLossEventList)
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
		
		threatSuspectibilityDistributionMean = pThreatSuspectibilityDistributionMean;
		threatSuspectibilityDistributionSD = pThreatSuspectibilityDistributionSD;
		
		numberOfAgents = pNumberOfAgents;
		numberOfTimeSteps = pNmberOfTimeSteps;
		
		networkHomophily = pNetworkHomophily;
		extremeIdeologyThreshold = pExtremeIdeologyThreshold;
		
		lossEventList = pLossEventList;
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
	
	public double getThreatSuspectibilityDistributionMean() {
		return threatSuspectibilityDistributionMean;
	}

	public void setThreatSuspectibilityDistributionMean(double pThreatSuspectibilityDistributionMean) {
		this.threatSuspectibilityDistributionMean = pThreatSuspectibilityDistributionMean;
	}

	public double getThreatSuspectibilityDistributionSD() {
		return threatSuspectibilityDistributionSD;
	}

	public void setThreatSuspectibilityDistributionSD(double pThreatSuspectibilityDistributionSD) {
		this.threatSuspectibilityDistributionSD = pThreatSuspectibilityDistributionSD;
	}

	public ArrayList<CollectiveLossEvent> getLossEventList() {
		return lossEventList;
	}

	public void setLossEventList(ArrayList<CollectiveLossEvent> pLossEventList) {
		this.lossEventList = pLossEventList;
	}

}
