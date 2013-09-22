package org.yogocodes.bikewars.services;

import org.yogocodes.bikewars.model.FightResultModel;

public interface FightingService {

	FightResultModel fight(Long attackerId, Long defenderId);

}
