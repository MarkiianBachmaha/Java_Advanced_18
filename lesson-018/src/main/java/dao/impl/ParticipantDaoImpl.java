package dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import domain.Level;
import domain.Participant;
import service.ParticipantService;

@Repository
public class ParticipantDaoImpl implements ParticipantService {

	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("James");
		participant1.setEmail("james@gmail.com");
		participant1.setPrimarySkill("Music");
		participant1.setLevel(Level.L4);

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Bob");
		participant2.setEmail("bob@gmail.com");
		participant2.setPrimarySkill("Psychology");
		participant2.setLevel(Level.L3);

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Paul");
		participant3.setEmail("paul@gmail.com");
		participant3.setPrimarySkill("Engilsh");
		participant3.setLevel(Level.L1);

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Fred");
		participant4.setEmail("fred@gmail.com");
		participant4.setPrimarySkill("Germany");
		participant4.setLevel(Level.L2);

		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);

	}

	@Override
	public List<Participant> findAllParticipants() {
		return participants;
	}

	@Override
	public Participant findOne(int id) {
		return participants.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@Override
	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int participantIndex = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(participantIndex, participantToUpdate);
		} else {
			// save
			participant.setId(participants.size() + 1);
			participants.add(participant);
		}
	}

	@Override
	public void delete(int id) {
		Iterator<Participant> iter = participants.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() == id) {
				iter.remove();
			}
		}
	}
}