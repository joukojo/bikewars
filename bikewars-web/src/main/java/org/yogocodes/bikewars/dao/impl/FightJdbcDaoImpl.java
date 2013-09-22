package org.yogocodes.bikewars.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yogocodes.bikewars.dao.FightDao;
import org.yogocodes.bikewars.model.FightResultModel;

/**
 * Created with IntelliJ IDEA.
 * User: joukojo
 * Date: 9/22/13
 * Time: 11:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("fightDao")
public class FightJdbcDaoImpl implements FightDao {

    private  final Logger logger = LoggerFactory.getLogger(FightJdbcDaoImpl.class);

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Override
    public void save(FightResultModel fightResult) {
        logger.trace("saving fight: {}", fightResult);
        if( fightResult.getFight() == null ) {
            insert(fightResult);
        }

    }

    protected void insert(FightResultModel fightResult) {

        String sql = "insert into user_fights(attacker_id, defender_id, attacker_won, money, created) values(?,?,?,?,?)";
        Object[] params = {fightResult.getAttackerId(), fightResult.getDefenderId(), fightResult.isAttackerWon(), fightResult.getMoney(), fightResult.getCreated()};

        jdbcTemplate.update(sql, params);
    }



}
