package com.github.idnbso.hit.java.assignments.solutions.innerclasses.comparator;

import java.util.*;

public class SchoolDemo
{

    public static void main(String[] args)
    {
        final int totalStudents = 10;
        Student[] schoolStudents = new Student[totalStudents];

        for (int i = 0; i < schoolStudents.length; i++)
        {
            schoolStudents[i] = new Student((long)(Math.random() * (999_999_999 - 100_000_000) + 100_000_000),
                                            (int)(Math.random() * 101));
        }

        System.out.println("before sorting by id: ");
        for (Student student : schoolStudents)
        {
            System.out.println(student);
        }

        Arrays.sort(schoolStudents, new Comparator<Student>()
        {
            @Override
            public int compare(Student student1, Student student2)
            {
                int result;
                long id1 = student1.getId();
                long id2 = student2.getId();

                if (id1 < id2)
                {
                    result = -1;
                }
                else if (id1 > id2)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }

                return result;
            }
        });

        System.out.println("after sorting by id: ");
        for (Student student : schoolStudents)
        {
            System.out.println(student);
        }
        
        
        System.out.println("before sorting by average: ");
        for (Student student : schoolStudents)
        {
            System.out.println(student);
        }

        Arrays.sort(schoolStudents, new Comparator<Student>()
        {
            @Override
            public int compare(Student student1, Student student2)
            {
                int result;
                double average1 = student1.getAverage();
                double average2 = student2.getAverage();

                if (average1 < average2)
                {
                    result = -1;
                }
                else if (average1 > average2)
                {
                    result = 1;
                }
                else
                {
                    result = 0;
                }

                return result;
            }
        });

        System.out.println("after sorting by average: ");
        for (Student student : schoolStudents)
        {
            System.out.println(student);
        }
    }
}
