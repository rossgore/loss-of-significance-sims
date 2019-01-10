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

	private ArrayList<Agent> agents;

	private NormalDistribution questValueDistribution;
	private NormalDistribution questThresholdDistribution;
	private NormalDistribution ideologyValueDistribution;
	private SocialNetwork sn;

	private int numberOfAgents;
	private int numberOfTimeSteps;
	private double networkHomophily;

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


		for (int i=0; i<numberOfAgents; i++)
		{
			Agent toInit = new Agent(questValueDistribution, questThresholdDistribution, 
					ideologyValueDistribution, input.getCorrBetweenIdeologyAndQuestValue());
			if (i % 100 == 0)
			{
				/**
				System.out.println("Ideology Value: "+toInit.getIdeology());
				System.out.println("Quest Value: "+toInit.getQuestForSignficanceValue());
				System.out.println();
				 **/
			}
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

	public int getNumberOfTimeSteps()
	{
		return this.numberOfTimeSteps;
	}

	public void step()
	{
		for (int i=0; i<agents.size(); i++)
		{
			agents.get(i).beSocial(agents);
		}
		for (int i=0; i<agents.size(); i++)
		{
			if (agents.get(i).isOnQuest())
			{
				agents.get(i).updateAgentAttributes(ON_QUEST_NETWORK_INFLUENCE);
			}
			else
			{
				agents.get(i).updateAgentAttributes(NON_QUEST_NETWORK_INFLUENCE);
			}

		}
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

}
