import java.util.ArrayList;

public class RunSimulation {

	public static void main(String [] args)
	{
		double corrBetweenIdeologyAndQuestValue = 0.8;
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
		double ideologyValueDistributionMean = 0.55;
		double ideologyValueDistributionSD = 0.15;
		double threatSuspectibilityDistributionMean = 0.5;
		double threatSuspectibilityDistributionSD = 0.05;
		int numberOfAgents = 2000;
		int nmberOfTimeSteps = 1000;
		double networkHomophily = 0.9;
		double extremeIdeologyThreshold = 0.1;

		ArrayList<CollectiveLossEvent> lossEvents = new ArrayList<CollectiveLossEvent>();

		CollectiveLossEvent event1 = new CollectiveLossEvent(100, 0.03);
		CollectiveLossEvent event2 = new CollectiveLossEvent(300, 0.07);
		CollectiveLossEvent event3 = new CollectiveLossEvent(400, 0.05);
		CollectiveLossEvent event4 = new CollectiveLossEvent(800, 0.10);

		lossEvents.add(event1);
		lossEvents.add(event2);
		lossEvents.add(event3);
		lossEvents.add(event4);

		InputParameterSet inputs = new InputParameterSet(corrBetweenIdeologyAndQuestValue,
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
				lossEvents
				);

		Simulation sim = new Simulation(inputs);
		for (int i=0; i<sim.getNumberOfTimeSteps(); i++)
		{
			sim.step(i);
			if (sim.isCollectiveLossStep(i))
			{
				CollectiveLossEvent event = sim.getLossEvent(i);
				
				System.out.println("Collective Loss Event Occurred At Time Step" + 
				                    event.getTimeStep() +"  With Intensity: "+event.getIntensity());
			}
			if (i % 100 == 0)
			{
				System.out.println("Simulated Time Step: "+i+" Statisitcs");
				System.out.println(sim.numberOfAgentsOnAQuest()+": on a quest");
				System.out.println(sim.numberOfExtremeAgents()+": are extreme");
				System.out.println(sim.numberOfNonViolentAgents()+": have a non-violent ideology");
				System.out.println(sim.numberOfViolentAgents()+": have a violent ideology");
				
			}

		}
	}
}
