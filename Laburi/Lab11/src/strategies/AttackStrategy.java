package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

import java.util.List;

public class AttackStrategy implements Strategy {
	private Hero hero;

	//TODO Implement constructor with a Hero as argument
	public AttackStrategy(Hero h) {
		hero = h;
	}

	@Override
	public void attack(Monster m) {
	    // TODO implement me

	    /*	Attack algorithm
			if hero type weapon found use it (x3 weapon damage)
				else if counter weapon found use it (x2 weapon damage)
				else basic attack (no bonus)
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */

		List<Treasure> treasureList = hero.getInventory();

		for (Treasure currTreasure : treasureList) {
			if (currTreasure.getDamageType() == hero.getDamageType()) {
				m.setHP(m.getHP() - currTreasure.getDmg() * 3);
				return;
			}
		}

		for (Treasure currTreasure : treasureList) {
			if (currTreasure.getDamageType() == m.getWeakness()) {
				m.setHP(m.getHP() - currTreasure.getDmg() * 2);
				return;
			}
		}

		m.setHP(m.getHP() - hero.getBaseDamage());
	}

}
