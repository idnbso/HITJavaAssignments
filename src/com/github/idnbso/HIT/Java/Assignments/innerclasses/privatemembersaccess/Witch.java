package com.github.idnbso.hit.java.assignments.innerclasses.privatemembersaccess;

public class Witch
{
    private String myRecipe;
    private Caldron caldron;
        
    public Witch(String myRecipe)
    {
        super();
        this.myRecipe = myRecipe;
    }

    public String getMyRecipe()
    {
        return myRecipe;
    }

    public void setMyRecipe(String myRecipe)
    {
        this.myRecipe = myRecipe;
    }

    public void setCaldron(Caldron caldron)
    {
        this.caldron = caldron;
    }

    public void castRecipe(String recipe)
    {
        caldron.currentRecipe = recipe;
    }
    
    public void castRecipe()
    {
        caldron.currentRecipe = myRecipe;
    } 
    
    class Caldron
    {
        private String currentRecipe = "None";

        public String getCurrentRecipe()
        {
            return currentRecipe;
        }
        
    }
}
