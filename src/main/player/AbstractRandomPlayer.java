package player;

import randomness.UniqueGenerator;

import java.util.Random;

public abstract class  AbstractRandomPlayer extends Player {
    private Random gen;
    public AbstractRandomPlayer(String name, boolean upperCase, int seed){
        super(name, upperCase);
        gen = UniqueGenerator.getGen(seed);
    }

    public Random getGen(){
        return gen;
    }
}
