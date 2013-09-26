package org.yogocodes.bikewars.dao;

import org.yogocodes.bikewars.model.FightResultModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: joukojo
 * Date: 9/22/13
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FightDao {
    void save(FightResultModel fightResult);

    List<FightResultModel> getLatestFights(Long userId, int pageNum, int pageSize);
}
