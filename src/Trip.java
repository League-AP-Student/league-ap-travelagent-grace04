import java.util.List;

public class Trip {
	private List<Flight> flights;

	public int getDuration() {
		int duration = 0;
		if(flights.size()>=1) {
			Time t2 = flights.get(flights.size()-1).getArrivalTime();
			Time t1 = flights.get(0).getDepartureTime();
			duration = t1.minutesUntil(t2);
		}
		return duration;
	}

	public int getShortestLayover() {
		int shortest = -1;
		int current;
		Time t1;
		Time t2;
		if(flights.size()>=2) {
			shortest = getDuration();
			for(int i=0;i<flights.size();i++) {
				t1=flights.get(i).getArrivalTime();
				t2=flights.get(i+1).getDepartureTime();
				current=t1.minutesUntil(t2);
				if(current<shortest) {
					shortest = current;
				}
			}
		}
		return shortest;
	}
}
