import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;

public class Agent {

	public static final double NONVIOLENT = 0;
	public static final double VIOLENT = 1;
	public static final double NEUTRAL = 0.5;
	


	/**
	 * Agents start with some initial value of a quest for significance. 
	 * Once it passes a threshold, it activates the quest for significance, 
	 * and changes how agents are influenced by other agents.
	 */
	private double questForSignficanceValue;
	private double questForSignificanceThreshold;

	private double questValueOfNetwork;
	private double ideologyValueOfNetwork;

	/**
	 * Agent’s ideology
	 * A continuous variable ranging from 0 to 1
	 * 0 = nonviolent; 1 = violent
	 * Any value below .5 represents a nonviolent ideology, with values closer to 0 representing stronger acceptance of/belief in nonviolence
	 * Any value above .5 represents a violent ideology, with values closer to 1 representing stronger acceptance of/belief in violence
	 */

	private double ideology; 
	private double threatSuspectibility;

	private int id;

	private double [] network;

	public boolean isIdeologyViolent()
	{
		//System.out.println("Comparing " + ideology + " to "+NEUTRAL);
		//System.out.println("returning: "+(ideology > NEUTRAL));
		return ideology > NEUTRAL;
	}

	public boolean isIdeologyNonViolent()
	{
		return ideology < NEUTRAL;
	}

	public boolean isIdeologyNeutral()
	{
		return ideology == NEUTRAL;
	}

	public Agent(NormalDistribution questForSignficanceValDist, NormalDistribution questForSignificanceThresholdDist, 
			NormalDistribution ideologyValueDist, NormalDistribution threatSuspectibilityDist, double corrSigIdeology)
	{
		this.setQuestForSignificanceThreshold(questForSignificanceThresholdDist.sample());
		this.setThreatSuspectibility(threatSuspectibilityDist.sample());
		this.setIdeologyValueOfNetwork(ideologyValueDist.getMean());
		this.setQuestValueOfNetwork(questForSignficanceValDist.getMean());
		if (Math.random() < ideologyValueDist.getMean())
		{
			CorrelatedVectors correlatedValues= new CorrelatedVectors(questForSignficanceValDist, corrSigIdeology, true);
			this.setQuestForSignficanceValue(correlatedValues.getSignficanceValue());
			this.setIdeology(correlatedValues.getIdeologyValue());
		}
		else
		{
			CorrelatedVectors correlatedValues= new CorrelatedVectors(questForSignficanceValDist, corrSigIdeology, false);
			this.setQuestForSignficanceValue(correlatedValues.getSignficanceValue());
			this.setIdeology(correlatedValues.getIdeologyValue());
		}

	}

	public double getQuestForSignficanceValue() 
	{
		return questForSignficanceValue;
	}

	public void setQuestForSignficanceValue(double pQuestForSignficanceValue) 
	{
		questForSignficanceValue = pQuestForSignficanceValue;
		questForSignficanceValue = Math.min(questForSignficanceValue, 1.0);
		questForSignficanceValue = Math.max(questForSignficanceValue, 0.0);
	}

	public double getQuestForSignificanceThreshold() 
	{
		return questForSignificanceThreshold;
	}

	public void setQuestForSignificanceThreshold(double pQuestForSignificanceThreshold) 
	{
		questForSignificanceThreshold = pQuestForSignificanceThreshold;
		questForSignificanceThreshold = Math.min(questForSignificanceThreshold, 1.0);
		questForSignificanceThreshold = Math.max(questForSignificanceThreshold, 0.0);
	}

	public double getIdeology()
	{
		return ideology;
	}

	public void setIdeology(double pIdeology)
	{
		ideology =  pIdeology;
		ideology = Math.min(ideology, 1.0);
		ideology = Math.max(ideology, 0.0);
	}

	public int getId() {
		return id;
	}

	public void setId(int pId) {
		id = pId;
	}

	public double [] getNetwork() {
		return network;
	}

	public void setNetwork(double [] pNetwork) {
		network = pNetwork;
	}

	public boolean isExtreme()
	{
		if (this.isIdeologyViolent())
		{
			return (this.getIdeology() > (Agent.VIOLENT-Simulation.EXTREME_THRESHOLD));
		}
		else if (this.isIdeologyNonViolent())
		{
			return (this.getIdeology() < (Agent.NONVIOLENT+Simulation.EXTREME_THRESHOLD));
		}
		else 
		{
			return false;
		}

	}

	public int getNetworkSize()
	{
		int numberOfNetworkConnections = 0;
		for (int i=0; i<network.length; i++)
		{
			if (network[i] != 0)
			{
				numberOfNetworkConnections++;
			}
		}
		return numberOfNetworkConnections;

	}

	public boolean isOnQuest()
	{
		return questForSignficanceValue > questForSignificanceThreshold;
	}

	public void beSocial(ArrayList<Agent> agentList)
	{
		double questValueInfluence = 0;
		double ideologyValueInfluence = 0;
		if (isOnQuest())
		{
			double totalWeightOfConnections = 0;
			for (int i=0; i<network.length; i++)
			{
				if (network[i] != 0.0)
				{
					Agent candidateAgent = agentList.get(i);
					boolean sameIdeology = (this.isIdeologyNonViolent() == candidateAgent.isIdeologyNonViolent());
					if (agentList.get(i).isExtreme())
					{
						totalWeightOfConnections += Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_EXTREME_AGENT,
								network[i]);
					}
					else if (agentList.get(i).isIdeologyViolent())
					{
						totalWeightOfConnections += Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_VIOLENT_AGENT,
								network[i]);
					}
					else if (sameIdeology)
					{
						totalWeightOfConnections += Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_SAME_IDEOLOGY_AGENT,
								network[i]);
					}
					else
					{
						totalWeightOfConnections += network[i];
					}
				}
			}

			for (int i=0; i<network.length; i++)
			{
				if (network[i] != 0.0 && i!=this.getId())
				{
					Agent candidateAgent = agentList.get(i);
					boolean sameIdeology = (this.isIdeologyNonViolent() == candidateAgent.isIdeologyNonViolent());
					double influenceValue=0;
					if (agentList.get(i).isExtreme())
					{
						influenceValue = Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_EXTREME_AGENT,
								network[i]);
					}
					else if (agentList.get(i).isIdeologyViolent())
					{
						influenceValue = Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_VIOLENT_AGENT,
								network[i]);
					}
					else if (sameIdeology)
					{
						influenceValue = Math.max(Simulation.IF_ON_QUEST_INFLUENCE_OF_SAME_IDEOLOGY_AGENT,
								network[i]);
					}
					else
					{
						influenceValue = network[i];
					}
					questValueInfluence += agentList.get(i).getQuestForSignficanceValue()*(influenceValue/totalWeightOfConnections);
					ideologyValueInfluence += agentList.get(i).getIdeology()*(influenceValue/totalWeightOfConnections);
				}
			}
			this.setIdeologyValueOfNetwork(ideologyValueInfluence);
			this.setQuestValueOfNetwork(questValueInfluence);
		}
		else
		{
			// this is someone who is not on a quest. 
			// they are affected by their connections in terms of the connection strength.

			double totalWeightOfConnections = 0;
			for (int i=0; i<network.length; i++)
			{
				totalWeightOfConnections += network[i];
			}

			for (int i=0; i<network.length; i++)
			{
				if (network[i] != 0.0 && i!=this.getId())
				{
					questValueInfluence += agentList.get(i).getQuestForSignficanceValue()*(network[i]/totalWeightOfConnections);
					ideologyValueInfluence += agentList.get(i).getIdeology()*(network[i]/totalWeightOfConnections);
				}
			}
		}
		this.setIdeologyValueOfNetwork(ideologyValueInfluence);
		this.setQuestValueOfNetwork(questValueInfluence);
	}


	public void updateAgentAttributes(double networkInfluence)
	{
		double newIdeologyValue;
		double newQuestValue;
		if (this.isOnQuest())
		{
			newQuestValue = this.getQuestForSignficanceValue()-
					Simulation.ON_QUEST_STEP_SIGNFICANCE_REDUCTION;
		}
		else
		{
			 newQuestValue = Math.pow(this.getQuestForSignficanceValue(), (1-networkInfluence))*
					Math.pow(this.getQuestValueOfNetwork(), networkInfluence);
		}
			 newIdeologyValue = Math.pow(this.getIdeology(), (1-networkInfluence))*
					Math.pow(this.getIdeologyValueOfNetwork(), networkInfluence);
		

		this.setQuestForSignficanceValue(newQuestValue);
		this.setIdeology(newIdeologyValue);
	}

	public double getQuestValueOfNetwork() {
		return questValueOfNetwork;
	}

	public void setQuestValueOfNetwork(double pQuestValueOfNetwork) {
		questValueOfNetwork = pQuestValueOfNetwork;
		questValueOfNetwork = Math.min(questValueOfNetwork, 1.0);
		questValueOfNetwork = Math.max(questValueOfNetwork, 0.0);
	}

	public double getIdeologyValueOfNetwork() {
		return ideologyValueOfNetwork;
	}

	public void setIdeologyValueOfNetwork(double pIdeologyValueOfNetwork) {
		ideologyValueOfNetwork = pIdeologyValueOfNetwork;
		ideologyValueOfNetwork = Math.min(ideologyValueOfNetwork, 1.0);
		ideologyValueOfNetwork = Math.max(ideologyValueOfNetwork, 0.0);
	}

	public double getThreatSuspectibility() {
		return threatSuspectibility;
	}

	public void setThreatSuspectibility(double pThreatSuspectibility) {
		threatSuspectibility = pThreatSuspectibility;
		threatSuspectibility = Math.min(threatSuspectibility, 1.0);
		threatSuspectibility = Math.max(threatSuspectibility, 0.0);
	}
}
