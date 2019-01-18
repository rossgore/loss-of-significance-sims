import java.util.ArrayList;

public class InputParameterSet {
	
	private double corrBetweenViolentIdeologyAndQuestValue;
	private double corrBetweenNonViolentIdeologyAndQuestValue;
	
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
	
	private double threatSuspectibilityDistributionMean;
	private double threatSuspectibilityDistributionSD;
	
	private int numberOfAgents;
	private int numberOfTimeSteps;
	
	private double networkHomophily;
	private double extremeIdeologyThreshold;
	
	private double individualLossEventFrequency;
	private double individualLossEventDistributionMean;
	private double individualLossEventDistributionSD;
	private double nonLossEventQuestValueReduction;
	
	private ArrayList<CollectiveLossEvent> lossEventList;
	
	
	public InputParameterSet(double pCorrBetweenViolentIdeologyAndQuestValue,
			double pCorrBetweenNonViolentIdeologyAndQuestValue,
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
			double pIndividualLossEventFrequency,
			double pIndividualLossEventDistributionMean,
			double pIndividualLossEventDistributionSD,
			double pNonLossEventQuestValueReduction,
			ArrayList<CollectiveLossEvent> pLossEventList)
	{
		setCorrBetweenViolentIdeologyAndQuestValue(pCorrBetweenViolentIdeologyAndQuestValue);
		setCorrBetweenNonViolentIdeologyAndQuestValue(pCorrBetweenNonViolentIdeologyAndQuestValue);
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
		
		individualLossEventFrequency = pIndividualLossEventFrequency;
		individualLossEventDistributionMean = pIndividualLossEventDistributionMean;
		individualLossEventDistributionSD = pIndividualLossEventDistributionSD;
		setNonLossEventQuestValueReduction(pNonLossEventQuestValueReduction);
		
		lossEventList = pLossEventList;
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

	public double getCorrBetweenViolentIdeologyAndQuestValue() {
		return corrBetweenViolentIdeologyAndQuestValue;
	}

	public void setCorrBetweenViolentIdeologyAndQuestValue(double pCorrBetweenViolentIdeologyAndQuestValue) {
		this.corrBetweenViolentIdeologyAndQuestValue = pCorrBetweenViolentIdeologyAndQuestValue;
	}

	public double getCorrBetweenNonViolentIdeologyAndQuestValue() {
		return corrBetweenNonViolentIdeologyAndQuestValue;
	}

	public void setCorrBetweenNonViolentIdeologyAndQuestValue(double pCorrBetweenNonViolentIdeologyAndQuestValue) {
		this.corrBetweenNonViolentIdeologyAndQuestValue = pCorrBetweenNonViolentIdeologyAndQuestValue;
	}

	public double getIndividualLossEventDistributionMean() {
		return individualLossEventDistributionMean;
	}

	public void setIndividualLossEventDistributionMean(double pIndividualLossEventDistributionMean) {
		this.individualLossEventDistributionMean = pIndividualLossEventDistributionMean;
	}

	public double getIndividualLossEventDistributionSD() {
		return individualLossEventDistributionSD;
	}

	public void setIndividualLossEventDistributionSD(double pIndividualLossEventDistributionSD) {
		this.individualLossEventDistributionSD = pIndividualLossEventDistributionSD;
	}

	public double getIndividualLossEventFrequency() {
		return individualLossEventFrequency;
	}

	public void setIndividualLossEventFrequency(double pIndividualLossEventFrequency) {
		this.individualLossEventFrequency = pIndividualLossEventFrequency;
	}


	public double getNonLossEventQuestValueReduction() {
		return nonLossEventQuestValueReduction;
	}

	public void setNonLossEventQuestValueReduction(double pNonLossEventQuestValueReduction) {
		this.nonLossEventQuestValueReduction = pNonLossEventQuestValueReduction;
	}

}
