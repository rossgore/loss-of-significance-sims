import java.util.ArrayList;

import org.apache.commons.math3.distribution.NormalDistribution;

public class Simulation {

	public static double ON_QUEST_NETWORK_INFLUENCE;
	public static double NON_QUEST_NETWORK_INFLUENCE;
	public static double ON_QUEST_STEP_SIGNFICANCE_REDUCTION;
	public static double IF_ON_QUEST_INFLUENCE_OF_EXTREME_AGENT;
	public static double IF_ON_QUEST_INFLUENCE_OF_SAME_IDEOLOGY_AGENT;
	public static double IF_ON_QUEST_INFLUENCE_OF_VIOLENT_AGENT;
	public static double EXTREME_THRESHOLD;

	private ArrayList<CollectiveLossEvent> collectiveLossEventSchedule;

	private ArrayList<Agent> agents;

	private NormalDistribution questValueDistribution;
	private NormalDistribution questThresholdDistribution;
	private NormalDistribution ideologyValueDistribution;
	private NormalDistribution threatSuspectibilityDistribution;

	private SocialNetwork sn;

	private int numberOfAgents;
	private int numberOfTimeSteps;
	private double networkHomophily;

	private IndividualLossEvent individualLossEvent;
	private double individualLossEventFrequency;
	private double nonLossEventQuestValueReduction;

	public Simulation(InputParameterSet input)
	{

		long seed = 12;
		String ego_type = "Ego";
		double[] ego_params = {input.getNumberOfAgents()};

		Simulation.ON_QUEST_NETWORK_INFLUENCE = input.getOnQuestNetworkInfluence();
		Simulation.NON_QUEST_NETWORK_INFLUENCE = input.getNonQuestNetworkInfluence();
		Simulation.ON_QUEST_STEP_SIGNFICANCE_REDUCTION = input.getOnQuestStepSignficanceReduction();
		Simulation.IF_ON_QUEST_INFLUENCE_OF_EXTREME_AGENT = input.getIfOnQuestInfluenceOfExtremeAgent();
		Simulation.IF_ON_QUEST_INFLUENCE_OF_SAME_IDEOLOGY_AGENT = input.getIfOnQuestInfluenceOfSameIdeologyAgent();
		Simulation.IF_ON_QUEST_INFLUENCE_OF_VIOLENT_AGENT = input.getIfOnQuestInfluenceOfViolentAgent();
		Simulation.EXTREME_THRESHOLD = input.getExtremeIdeologyThreshold();

		sn = new SocialNetwork(ego_type, ego_params, seed);
		numberOfAgents = input.getNumberOfAgents();
		numberOfTimeSteps = input.getNumberOfTimeSteps();
		networkHomophily = input.getNetworkHomophily();

		agents = new ArrayList<Agent>();

		double questValueMean = input.getQuestValueDistributionMean();
		double questValueSD = input.getQuestValueDistributionSD();
		questValueDistribution = new NormalDistribution(questValueMean, questValueSD);

		double questThresholdMean = input.getQuestThresholdDistributionMean();
		double questThresholdSD = input.getQuestThresholdDistributionSD();
		questThresholdDistribution = new NormalDistribution (questThresholdMean, questThresholdSD);

		double ideologyValueMean = input.getIdeologyValueDistributionMean();
		double ideologyValueSD = input.getIdeologyValueDistributionSD();
		ideologyValueDistribution = new NormalDistribution(ideologyValueMean, ideologyValueSD);

		double theatSuspectibilityValueMean = input.getThreatSuspectibilityDistributionMean();
		double theatSuspectibilityValueSD = input.getThreatSuspectibilityDistributionSD();
		threatSuspectibilityDistribution = new NormalDistribution(theatSuspectibilityValueMean, theatSuspectibilityValueSD);
		
		individualLossEvent = new IndividualLossEvent(input.getIndividualLossEventDistributionMean(), 
				input.getIndividualLossEventDistributionSD());
		
		individualLossEventFrequency = input.getIndividualLossEventFrequency();
		nonLossEventQuestValueReduction = input.getNonLossEventQuestValueReduction();
		
		collectiveLossEventSchedule = input.getLossEventList();

		for (int i=0; i<numberOfAgents; i++)
		{
			Agent toInit = new Agent(questValueDistribution, questThresholdDistribution, 
					ideologyValueDistribution, threatSuspectibilityDistribution,
					input.getCorrBetweenNonViolentIdeologyAndQuestValue(), 
					input.getCorrBetweenViolentIdeologyAndQuestValue());

			toInit.setId(i);
			agents.add(toInit);
		}

		// walk through social network and drop connections based on homophily
		double [][] snAsMatrix = sn.network;
		for (int i=0; i<snAsMatrix.length; i++)
		{
			Agent candidateAgent = agents.get(i);
			for (int j=0; j<snAsMatrix[0].length; j++)
			{

				if (i!=j && snAsMatrix[i][j] > 0.0)
				{
					Agent otherAgentInNetwork = agents.get(j);
					boolean ideologyMisaligned = candidateAgent.isIdeologyViolent() != otherAgentInNetwork.isIdeologyViolent();
					if (ideologyMisaligned && Math.random()<networkHomophily)
					{
						snAsMatrix[i][j] = 0.0;
					}
				}
			}
			agents.get(i).setNetwork(snAsMatrix[i]);
		}
	}

	public ArrayList<Agent> getAgents()
	{
		return agents;
	}

	public CollectiveLossEvent getLossEvent(int curStep)
	{
		CollectiveLossEvent toReturn = null;
		for (int i=0; i<this.getCollectiveLossEventSchedule().size(); i++)
		{
			CollectiveLossEvent event = this.getCollectiveLossEventSchedule().get(i);
			if (event.getTimeStep() == curStep)
			{
				toReturn = event;
			}
		}
		return toReturn;
	}

	public boolean isCollectiveLossStep (int curStep)
	{
		boolean answer = false;
		for (int i=0; i<this.getCollectiveLossEventSchedule().size(); i++)
		{
			CollectiveLossEvent event = this.getCollectiveLossEventSchedule().get(i);
			if (event.getTimeStep() == curStep)
			{
				answer = true;
			}
		}
		return answer;
	}

	public void step(int timeStep)
	{
		// collective loss events
		if (this.isCollectiveLossStep(timeStep))
		{
			CollectiveLossEvent event = this.getLossEvent(timeStep);
			for (int i=0; i<agents.size(); i++)
			{
				/**
				 * CHECK IF THIS IS RIGHT WITH GROUP.
				 */
				double incAgentQuestValue = event.getIncToQuestValue(agents.get(i).getThreatSuspectibility());
				agents.get(i).updateAgentQuestValue(incAgentQuestValue);
			}
		}
		// individual loss events
		for (int i=0; i<agents.size(); i++)
		{
			// if event doesn't happen it is relaxing
			double incAgentQuestValue = -1 * this.getNonLossEventQuestValueReduction();
			
			// if event does happen it increases quest
			if (Math.random() < this.getIndividualLossEventFrequency())
			{
				incAgentQuestValue = this.getIndividualLossEvent().getLossEventIntensity();
			}
			agents.get(i).updateAgentQuestValue(incAgentQuestValue);
		}
		
		// time step socialization
		for (int i=0; i<agents.size(); i++)
		{
			agents.get(i).beSocial(agents);
		}
		
		// update ideology based on socialization
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isOnQuest())
			{
				agents.get(i).updateAgentIdeology(ON_QUEST_NETWORK_INFLUENCE);
			}
			else
			{
				agents.get(i).updateAgentIdeology(NON_QUEST_NETWORK_INFLUENCE);
			}

		}
	}
	
	public void printStats(int timeStep)
	{
		int numberOfNonViolentAgents=0;
		int numberOfViolentAgents=0;
		
		int numberOfViolentAndExtremeAgents = 0;
		int numberOfNonViolentAndExtremeAgents = 0;
		
		double averageQuestValue=0;
		double averageIdeologyValue=0;
		
		double averageNonViolentQuestValue=0;
		double averageNonViolentIdeologyValue=0;
		
		double averageViolentQuestValue=0;
		double averageViolentIdeologyValue=0;
		
		for (int i=0; i<agents.size(); i++)
		{
			Agent agentI = agents.get(i);
			averageQuestValue += agentI.getQuestForSignficanceValue();
			averageIdeologyValue += agentI.getIdeology();
			
			if (agentI.isIdeologyViolent())
			{
				averageViolentQuestValue += agentI.getQuestForSignficanceValue();
				averageIdeologyValue += agentI.getIdeology();
				
				numberOfViolentAgents++;
				if (agentI.isExtreme())
				{
					numberOfViolentAndExtremeAgents++;
				}
			}
			
			if (agentI.isIdeologyNonViolent())
			{
				averageNonViolentQuestValue += agentI.getQuestForSignficanceValue();
				averageNonViolentIdeologyValue += agentI.getIdeology();
				
				numberOfNonViolentAgents++;
				if (agentI.isExtreme())
				{
					numberOfNonViolentAndExtremeAgents++;
				}
			}
		}
		
		System.out.println(timeStep+", Number.Of.Non.Violent.Agents, "+numberOfNonViolentAgents);
		System.out.println(timeStep+", Number.Of.Violent.Agents, "+numberOfViolentAgents);
		
		System.out.println(timeStep+", Number.Of.Violent.And.Extreme.Agents, "+numberOfViolentAndExtremeAgents);
		System.out.println(timeStep+", Number.Of.Non.Violent.Extreme.Agents, "+numberOfNonViolentAndExtremeAgents);
		
		System.out.println(timeStep+", Average.Quest.Value, "+averageQuestValue);
		System.out.println(timeStep+", Average.Ideology.Value, "+averageIdeologyValue);
		
		System.out.println(timeStep+", Average.Non.Violent.Quest.Value, "+averageNonViolentQuestValue);
		System.out.println(timeStep+", Average.Non.Violent.Ideology.Value, "+averageNonViolentIdeologyValue);
		
		System.out.println(timeStep+", Average.Violent.Quest.Value, "+averageViolentQuestValue);
		System.out.println(timeStep+", Average.Violent.Ideology.Value, "+averageViolentIdeologyValue);
	}
	
	public int numberOfViolentAgents()
	{
		int count = 0;
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isIdeologyViolent())
			{
				count++;
			}
		}
		return count;
	}
	public int numberOfNonViolentAgents()
	{
		int count = 0;
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isIdeologyNonViolent())
			{
				count++;
			}
		}
		return count;
	}
	public int numberOfExtremeAgents()
	{
		int count = 0;
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isExtreme())
			{
				count++;
			}
		}
		return count;
	}
	public int numberOfAgentsOnAQuest()
	{
		int count = 0;
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isOnQuest())
			{
				count++;
			}
		}
		return count;
	}

	public ArrayList<CollectiveLossEvent> getCollectiveLossEventSchedule() {
		return collectiveLossEventSchedule;
	}

	public int getNumberOfTimeSteps()
	{
		return this.numberOfTimeSteps;
	}

	public IndividualLossEvent getIndividualLossEvent() {
		return individualLossEvent;
	}
	
	public double getIndividualLossEventFrequency()
	{
		return this.individualLossEventFrequency;
	}
	
	public double getNonLossEventQuestValueReduction()
	{
		return this.nonLossEventQuestValueReduction;
	}


}
