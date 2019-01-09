package strategies;

import entities.Hero;
import entities.Monster;
import entities.Treasure;

public class DefenseStrategy implements Strategy {
	private Hero hero;

	//TODO Implement constructor with a Hero as argument
	public DefenseStrategy(Hero h) {
		hero = h;
	}

	@Override
	public void attack(Monster m) {
		// TODO implement me

	    /*	Attack algorithm
			if hero type weapon found boost HP with treasure.getHpBoost() + hero.getBaseHpBoost()
				else boost HP with getBaseHpBoost()
			Do a basic attack on the monster -> hero.getBaseDamage()
			--> In order to find the weapon, iterate through the inventory of the hero.
	    */
		m.setHP(m.getHP() - hero.getBaseDamage());

		for (Treasure currTreasure : hero.getInventory()) {
			if (currTreasure.getDamageType() == hero.getDamageType()) {
				hero.setHP(hero.getHP() + currTreasure.getBoostHp() + hero.getBaseHpBoost());
				return;
			}
		}

		hero.setHP(hero.getHP() + hero.getBaseHpBoost());
	}

}
