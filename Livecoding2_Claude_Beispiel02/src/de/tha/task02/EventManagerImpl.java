package de.tha.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EventManagerImpl implements EventManager, Iterable<Participant>{
	
	protected Map<Participant, Integer> register;
	
	public EventManagerImpl() {
		this.register = new HashMap<Participant, Integer>();
	}

	@Override
	public Iterator<Participant> iterator() {
		List<Participant> activeList = new ArrayList<Participant>(register.keySet());
		Collections.sort(activeList);
		return activeList.iterator();
	}

	@Override
	public void register(Participant participant, int count) {
		if (count > 0) {
			register.merge(participant, count, Integer::sum);			
		}
	}

	@Override
	public Map<Participant, Integer> getRegister() {
		return new HashMap<Participant, Integer>(register);
	}

	@Override
	public int getBookingCount(Participant participant) {
		return register.getOrDefault(participant, 0);
	}

	@Override
	public List<Participant> listActiveParticipants(String membershipType) {
		List<Participant> activeList = new ArrayList<Participant>();
		for (Map.Entry<Participant, Integer> entries : register.entrySet()) {
			Participant p = entries.getKey();
			int bookings = entries.getValue();
			
			if (bookings > 0 && p.getMembershipType().equals(membershipType)) {
				activeList.add(p);
			}
		}
		Collections.sort(activeList.reversed());
		return activeList;
	}
	

}
