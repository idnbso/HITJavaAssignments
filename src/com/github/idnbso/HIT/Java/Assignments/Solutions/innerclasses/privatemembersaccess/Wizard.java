package com.github.idnbso.hit.java.assignments.solutions.innerclasses.privatemembersaccess;

public class Wizard
{
    private int health;

    public Wizard(int health)
    {
        super();
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    class SpellBook
    {
        private final int magicalMagnitude;

        public SpellBook(int magicalMagnitude)
        {
            super();
            this.magicalMagnitude = magicalMagnitude;
        }

        public int getMagicalMagnitude()
        {
            return magicalMagnitude;
        }

        public void healUser()
        {
            health += magicalMagnitude;
        }

    }
}
