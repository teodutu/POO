package commands;

import entities.Hero;

public class MoveCommand implements Command {
	private Hero hero;
	private Hero.Direction direction;

	// TODO implement the move command
    /*  - MoveCommand(Hero, Direction)
        - void undo()
        - void execute()
        - maybe helper method for undo ?
    */

	public MoveCommand(Hero h, Hero.Direction dir) {
		hero = h;
		direction = dir;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		hero.move(getBackDirection());
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		hero.move(direction);
	}

	private Hero.Direction getBackDirection() {
		switch (direction) {
			case E:
				return Hero.Direction.W;
			case N:
				return Hero.Direction.S;
			case W:
				return Hero.Direction.E;
			case S:
				return Hero.Direction.N;
			default:
				return null;
		}
	}
}
