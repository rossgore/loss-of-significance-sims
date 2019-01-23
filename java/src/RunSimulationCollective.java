import java.util.ArrayList;

public class RunSimulationCollective {

	public static void main(String [] args)
	{
		double corrBetweenViolentIdeologyAndQuestValue = 0.8;
		double corrBetweenNonViolentIdeologyAndQuestValue = 0.5;

		double onQuestNetworkInfluence = 0.05;
		double nonQuestNetworkInfluence = 0.01;

		double onQuestStepSignficanceReduction = 0.001;

		double ifOnQuestInfluenceOfExtremeAgent = 0.8;
		double ifOnQuestInfluenceOfSameIdeologyAgent = 0.9;
		double ifOnQuestInfluenceOfViolentAgent = 1.0;

		double questValueDistributionMean = 0.5;
		double questValueDistributionSD = 0.05;

		double questThresholdDistributionMean = 0.85;
		double questThresholdDistributionSD = 0.05;

		double ideologyValueDistributionMean = 0.40;
		double ideologyValueDistributionSD = 0.15;

		double threatSuspectibilityDistributionMean = 0.5;
		double threatSuspectibilityDistributionSD = 0.05;

		int numberOfAgents = 2000;
		int nmberOfTimeSteps = 1000;

		double networkHomophily = 1.0;

		double extremeIdeologyThreshold = 0.1;

		double individualLossEventFrequency = 0.05;

		double individualLossEventDistributionMean = 0.005;
		double individualLossEventDistributionSD = 0.001;

		double nonLossEventQuestValueReduction = 0.001;

		ArrayList<CollectiveLossEvent> lossEvents = new ArrayList<CollectiveLossEvent>();

		CollectiveLossEvent event1 = new CollectiveLossEvent(100, 0.03);
		CollectiveLossEvent event2 = new CollectiveLossEvent(250, 0.07);
		CollectiveLossEvent event3 = new CollectiveLossEvent(350, 0.05);


		lossEvents.add(event1);
		lossEvents.add(event2);
		lossEvents.add(event3);

		InputParameterSet inputs = new InputParameterSet(corrBetweenViolentIdeologyAndQuestValue,
				corrBetweenNonViolentIdeologyAndQuestValue,
				onQuestNetworkInfluence,
				nonQuestNetworkInfluence,
				onQuestStepSignficanceReduction,
				ifOnQuestInfluenceOfExtremeAgent,
				ifOnQuestInfluenceOfSameIdeologyAgent,
				ifOnQuestInfluenceOfViolentAgent,
				questValueDistributionMean,
				questValueDistributionSD,
				questThresholdDistributionMean,
				questThresholdDistributionSD,
				ideologyValueDistributionMean,
				ideologyValueDistributionSD,
				threatSuspectibilityDistributionMean,
				threatSuspectibilityDistributionSD,
				numberOfAgents,
				nmberOfTimeSteps,
				networkHomophily,
				extremeIdeologyThreshold,
				individualLossEventFrequency,
				individualLossEventDistributionMean,
				individualLossEventDistributionSD,
				nonLossEventQuestValueReduction,
				lossEvents
				);

		Simulation sim = new Simulation(inputs);
		for (int i=0; i<sim.getNumberOfTimeSteps(); i++)
		{
			sim.step(i);
			sim.printStats(i);
		}
	}
}
