package de.tha.task02;

import java.util.Objects;

public class ParticipantImpl implements Participant, Comparable<Participant>{
	
	private String memberId;
	private String name;
	private String membershipType;
	private int visitCount;
	
	public ParticipantImpl(String memberId, String name, String membershipType, int visitCount) {
		this.memberId = memberId;
		this.name = name;
		this.membershipType = membershipType;
		this.visitCount = visitCount;
	}

	@Override
	public int compareTo(Participant p) {
		return Integer.compare(visitCount, p.getVisitCount());
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipantImpl other = (ParticipantImpl) obj;
		return Objects.equals(memberId, other.memberId);
	}
	
	@Override
	public String toString() {
		return "ParticipantImpl [memberId=" + memberId + ", name=" + name + ", membershipType=" + membershipType
				+ ", visitCount=" + visitCount + "]";
	}

	@Override
	public String getMemberId() {
		return this.memberId;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getMembershipType() {
		return this.membershipType;
	}

	@Override
	public int getVisitCount() {
		return this.visitCount;
	}
	
	

}
