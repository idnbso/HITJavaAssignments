package com.github.idnbso.hit.java.assignments.innerclasses.humanmind;

public class HumanBody
{
    private Leg[] legs;
    private Hand[] hands;
    private Brain brain;

    public HumanBody(Brain brain)
    {
        super();
        this.brain = brain;
        this.legs = new Leg[2];
        this.legs[0] = new Leg("left");
        this.legs[1] = new Leg("right");
        this.hands = new Hand[2];
        this.hands[0] = new Hand("left");
        this.hands[1] = new Hand("right");
    }

    abstract class BodyPart
    {
        public abstract void vibe(int amount);
    }
    
    class Brain extends BodyPart
    {
        private int size;
        
        public Brain(int size)
        {
            this.size = size;
        }

        public int getSize()
        {
            return size;
        }

        @Override
        public void vibe(int amount)
        {
            legs[0].vibe(amount);
            legs[1].vibe(amount);
            hands[0].vibe(amount);
            hands[1].vibe(amount);
        }
    }

    class Hand extends BodyPart
    {
        private final String side;
        
        public Hand(String side)
        {
            this.side = side;
        }

        @Override
        public void vibe(int amount)
        {
            for (int iteration = 0; iteration < amount; iteration++)
            {
                System.out.println("The " + side + " hand is vibrating...");
            }
        }
    }

    class Leg extends BodyPart
    {
        private final String side;
        
        public Leg(String side)
        {
            this.side = side;
        }

        @Override
        public void vibe(int amount)
        {
            for (int iteration = 0; iteration < amount; iteration++)
            {
                System.out.println("The " + side + " leg is vibrating...");
            }
        }
    }
}
