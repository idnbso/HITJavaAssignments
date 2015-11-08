package com.github.idnbso.hit.java.assignments.solutions.innerclasses.humanmind;

public class HumanBody
{
    private Leg[] legs;
    private Hand[] hands;
    private Brain brain;

    public HumanBody(Brain brain, Hand hand, Leg leg)
    {
        super();
        this.brain = brain;
        this.legs = new Leg[2];
        this.legs[0] = leg;
        this.legs[1] = leg;
        this.hands = new Hand[2];
        this.hands[0] = hand;
        this.hands[1] = hand;
    }

    abstract class BodyPart
    {
        public abstract void vibe(int amount);

        private int size;

        public BodyPart(int size)
        {
            this.size = size;
        }

        public int getSize()
        {
            return size;
        }
    }
    
    class Brain extends BodyPart
    {
        public Brain(int size)
        {
            super(size);
        }

        @Override
        public void vibe(int amount)
        {
            System.out.print("the left ");
            legs[0].vibe(amount);
            System.out.print("the right ");
            legs[1].vibe(amount);
            System.out.print("the left ");
            hands[0].vibe(amount);
            System.out.print("the right ");
            hands[1].vibe(amount);
        }
    }

    class Hand extends BodyPart
    {
        public Hand(int size)
        {
            super(size);
        }

        @Override
        public void vibe(int amount)
        {
            for (int iteration = 0; iteration < amount; iteration++)
            {
                System.out.println("hand is vibrating...");
            }
        }
    }

    class Leg extends BodyPart
    {
        public Leg(int size)
        {
            super(size);
        }

        @Override
        public void vibe(int amount)
        {
            for (int iteration = 0; iteration < amount; iteration++)
            {
                System.out.println("leg is vibrating...");
            }
        }
    }
}
