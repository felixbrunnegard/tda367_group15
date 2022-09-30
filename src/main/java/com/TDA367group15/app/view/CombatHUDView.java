package com.TDA367group15.app.view;

import com.TDA367group15.app.model.Enemy;
import com.TDA367group15.app.model.Player;

import java.util.List;

public class CombatHUDView extends CombatView {
    public CombatHUDView(Player player, List<Enemy> enemies) {
        super(player, enemies);
    }
}
