package com.github.idnbso.hit.java.assignments.solutions.innerclasses.privatemembersaccess;

public class PrivateMemersAccessDemo
{

    public static void main(String[] args)
    {
        Wizard merlin = new Wizard(90);
        Wizard.SpellBook merlinsGrimore = merlin.new SpellBook(50);
        System.out.println("Merlin about to use the healUser() of the inner class SpellBook which modifies his Wizard class private health member.");
        System.out.println("Health before casting healUser(): " + merlin.getHealth());
        merlinsGrimore.healUser();
        System.out.println("Health after casting healUser(): " + merlin.getHealth());
        
        System.out.println();
        
        Witch grizelda = new Witch("Magical Potion");
        Witch.Caldron grizeldasCaldron = grizelda.new Caldron();
        grizelda.setCaldron(grizeldasCaldron);
        System.out.println("Grizelda about to use castRecipe() which modifies her Caldron inner class private currentRecipe member.");
        System.out.println("Current recipe before using casrRecipe(): " + grizeldasCaldron.getCurrentRecipe());
        grizelda.castRecipe();
        System.out.println("Current recipe after using casrRecipe(): " + grizeldasCaldron.getCurrentRecipe());      
    }

}
