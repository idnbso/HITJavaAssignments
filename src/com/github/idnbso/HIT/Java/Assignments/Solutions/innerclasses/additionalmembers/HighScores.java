package com.github.idnbso.hit.java.assignments.solutions.innerclasses.additionalmembers;

import java.util.*;

public class HighScores
{
    private List<Score> scores;

    public HighScores()
    {
        super();
        scores = new ArrayList<Score>();
    }

    public void addNewHighScore(Score newScore)
    {
        if (checkForNewHighScore(newScore))
        {
            scores.add(newScore);
        }
    }

    private boolean checkForNewHighScore(Score newScore)
    {
        boolean isNewHighScore = false;
        
        for (Score existingScore : scores )
        {
            if (existingScore.value <= newScore.value)
            {
                isNewHighScore = true;
            }
        }
            
        return isNewHighScore;
    }

    @Override
    public String toString()
    {
        return "HighScores [scores=" + scores + "]";
    }

    class Score
    {
        private int value;
        
        public Score(int value)
        {
            super();
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "Score [value=" + value + "]";
        }
    }
}
