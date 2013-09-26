package org.yogocodes.bikewars.dao.impl;

import org.springframework.jdbc.core.RowMapper;
import org.yogocodes.bikewars.model.FightResultModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: joukojo
 * Date: 9/23/13
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class FightResultRowMapper implements RowMapper<FightResultModel> {
    @Override
    public FightResultModel mapRow(ResultSet resultSet, int i) throws SQLException {
        FightResultModel fightResultModel = new FightResultModel();

        Long id = resultSet.getLong("id");
        Long attackerId = resultSet.getLong("attacker_id");
        Long defenderId = resultSet.getLong("defender_id");
        Boolean attackerWon = resultSet.getBoolean("attacker_won");
        Long money = resultSet.getLong("money");
        // Integer health = resultSet.getInt("health");
        Date created = resultSet.getDate("created");
        fightResultModel.setFight(id);
        fightResultModel.setAttackerId(attackerId);
        fightResultModel.setAttackerWon(attackerWon);
        fightResultModel.setCreated(created);
        fightResultModel.setDefenderId(defenderId);
        fightResultModel.setMoney(money);

        return fightResultModel;
    }
}
