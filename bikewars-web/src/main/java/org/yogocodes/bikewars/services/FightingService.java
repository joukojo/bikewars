package org.yogocodes.bikewars.services;

import org.yogocodes.bikewars.model.FightResultModel;

import java.util.List;

public interface FightingService {

	FightResultModel fight(Long attackerId, Long defenderId);

    List<FightResultModel> getRecentFights(Long userId, Integer pageNum, Integer pageSize);
}
